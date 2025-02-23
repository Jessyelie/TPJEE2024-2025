import { useState, useEffect } from 'react';
import Controllers from '../controllers/Controllers';
import Modal from '../components/Modal';
import { Classes } from "../models/types";

function ViewClasses() {
  const [classes, setClasses] = useState<Classes[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [selectedClass, setSelectedClass] = useState<Classes | null>(null);
  const [modalType, setModalType] = useState<'add' | 'edit' | 'delete' | null>(null);

  useEffect(() => {
    loadClasses();
  }, []);

  const loadClasses = async () => {
    setLoading(true);
    setError(null);
    try {
      const data = await Controllers().obtenirTous<Classes>('classes');
      setClasses(Array.isArray(data) ? data : []);
    } catch (error) {
      setError('Erreur lors du chargement des classes');
      console.error(error);
    } finally {
      setLoading(false);
    }
  };

  const handleOpenModal = (type: 'add' | 'edit' | 'delete', classItem?: Classes) => {
    setSelectedClass(classItem || { id: 0, name: '', description: '', archive: false, sector: { id: 0, name: '', archive: false } });
    setModalType(type);
    setIsModalVisible(true);
  };

  const handleCloseModal = () => {
    setIsModalVisible(false);
    setTimeout(() => {
      setSelectedClass(null);
      setModalType(null);
    }, 300);
  };

  const handleSave = async () => {
    if (!selectedClass) return;
    try {
      if (modalType === 'add') {
        const newClass = await Controllers().ajouter<Classes>('classes', selectedClass);
        setClasses([...classes, newClass]);
      } else if (modalType === 'edit' && selectedClass.id) {
        const updatedClass = await Controllers().modifier<Classes>('classes', selectedClass.id, selectedClass);
        setClasses(classes.map(cls => cls.id === updatedClass.id ? updatedClass : cls));
      }
    } catch (error) {
      console.error('Erreur lors de la sauvegarde de la classe', error);
    }
    handleCloseModal();
  };

  const handleDelete = async () => {
    if (!selectedClass || !selectedClass.id) return;
    try {
      await Controllers().supprimer('classes', selectedClass.id);
      setClasses(classes.filter(cls => cls.id !== selectedClass.id));
    } catch (error) {
      console.error('Erreur lors de la suppression de la classe', error);
    }
    handleCloseModal();
  };

  return (
    <div className="container">
      <h1>Gestion des Classes</h1>
      <button className="btn btn-primary" onClick={() => handleOpenModal('add')}>Ajouter une classe</button>
      {loading ? <p>Chargement...</p> : error ? <p className="text-danger">{error}</p> : (
        <table className="table table-striped">
          <thead>
            <tr>
              <th>Nom</th>
              <th>Description</th>
              <th>Archivé</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {classes.map(cls => (
              <tr key={cls.id}>
                <td>{cls.name}</td>
                <td>{cls.description}</td>
                <td>{cls.archive ? 'Oui' : 'Non'}</td>
                <td>
                  <button className="btn btn-sm btn-info me-2" onClick={() => handleOpenModal('edit', cls)}>Modifier</button>
                  <button className="btn btn-sm btn-danger" onClick={() => handleOpenModal('delete', cls)}>Supprimer</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}

      {/* Modal */}
      <Modal
        isVisible={isModalVisible}
        title={
          modalType === 'add' ? 'Ajouter une classe' :
          modalType === 'edit' ? 'Modifier une classe' :
          modalType === 'delete' ? 'Confirmer la suppression' : ''
        }
        body={
          modalType === 'delete' ? (
            <p>Es-tu sûr de vouloir supprimer {selectedClass?.name} ?</p>
          ) : (
            <form>
              <div className="mb-3">
                <label className="form-label">Nom</label>
                <input type="text" className="form-control"
                  value={selectedClass?.name || ''}
                  onChange={(e) => setSelectedClass(prev => ({ ...prev!, name: e.target.value }))} />
              </div>
              <div className="mb-3">
                <label className="form-label">Description</label>
                <input type="text" className="form-control"
                  value={selectedClass?.description || ''}
                  onChange={(e) => setSelectedClass(prev => ({ ...prev!, description: e.target.value }))} />
              </div>
              <div className="mb-3 form-check">
                <input type="checkbox" className="form-check-input"
                  checked={selectedClass?.archive || false}
                  onChange={(e) => setSelectedClass(prev => ({ ...prev!, archive: e.target.checked }))} />
                <label className="form-check-label">Archivé</label>
              </div>
            </form>
          )
        }
        footer={
          modalType === 'delete' ? (
            <>
              <button className="btn btn-secondary" onClick={handleCloseModal}>Annuler</button>
              <button className="btn btn-danger" onClick={handleDelete}>Supprimer</button>
            </>
          ) : (
            <>
              <button className="btn btn-secondary" onClick={handleCloseModal}>Annuler</button>
              <button className="btn btn-primary" onClick={handleSave}>Sauvegarder</button>
            </>
          )
        }
        fncs={{ onClose: handleCloseModal }}
      />
    </div>
  );
}

export default ViewClasses;
