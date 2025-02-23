import { useState, useEffect } from 'react';
import Controllers from '../controllers/Controllers';
import Modal from '../components/Modal';
import { Teacher } from '../models/types';

function Teachers() {
  const [teachers, setTeachers] = useState<Teacher[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [selectedTeacher, setSelectedTeacher] = useState<Teacher | null>(null);
  const [modalType, setModalType] = useState<'add' | 'edit' | 'delete' | null>(null);

  useEffect(() => {
    loadTeachers();
  }, []);

  const loadTeachers = async () => {
    setLoading(true);
    setError(null);
    try {
      const data = await Controllers().obtenirTous<Teacher>('teachers');
      setTeachers(Array.isArray(data) ? data : []);
    } catch (error) {
      setError('Erreur lors du chargement des enseignants');
      console.error(error);
    } finally {
      setLoading(false);
    }
  };

  const handleOpenModal = (type: 'add' | 'edit' | 'delete', teacher?: Teacher) => {
    setSelectedTeacher(teacher || { id: 0, firstName: '', lastName: '', emailPro: '', emailPerso: '', phoneNumber: '', address: '', archive: false });
    setModalType(type);
    setIsModalVisible(true);
  };

  const handleCloseModal = () => {
    setIsModalVisible(false);
    setTimeout(() => {
      setSelectedTeacher(null);
      setModalType(null);
    }, 300);
  };

  const handleSave = async () => {
    if (!selectedTeacher) return;
    try {
      if (modalType === 'add') {
        const newTeacher = await Controllers().ajouter<Teacher>('teachers', selectedTeacher);
        setTeachers([...teachers, newTeacher]);
      } else if (modalType === 'edit' && selectedTeacher.id) {
        const updatedTeacher = await Controllers().modifier<Teacher>('teachers', selectedTeacher.id, selectedTeacher);
        setTeachers(teachers.map(teacher => teacher.id === updatedTeacher.id ? updatedTeacher : teacher));
      }
    } catch (error) {
      console.error('Erreur lors de la sauvegarde de l’enseignant', error);
    }
    handleCloseModal();
  };

  const handleDelete = async () => {
    if (!selectedTeacher || !selectedTeacher.id) return;
    try {
      await Controllers().supprimer('teachers', selectedTeacher.id);
      setTeachers(teachers.filter(teacher => teacher.id !== selectedTeacher.id));
    } catch (error) {
      console.error('Erreur lors de la suppression de l’enseignant', error);
    }
    handleCloseModal();
  };

  return (
    <div className="container">
      <h1>Gestion des Enseignants</h1>
      <button className="btn btn-primary" onClick={() => handleOpenModal('add')}>Ajouter un enseignant</button>
      {loading ? <p>Chargement...</p> : error ? <p className="text-danger">{error}</p> : (
        <table className="table table-striped">
          <thead>
            <tr>
              <th>Nom</th>
              <th>Prénom</th>
              <th>Email Pro</th>
              <th>Email Perso</th>
              <th>Téléphone</th>
              <th>Adresse</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {teachers.map(teacher => (
              <tr key={teacher.id}>
                <td>{teacher.lastName}</td>
                <td>{teacher.firstName}</td>
                <td>{teacher.emailPro}</td>
                <td>{teacher.emailPerso}</td>
                <td>{teacher.phoneNumber}</td>
                <td>{teacher.address}</td>
                <td>
                  <button className="btn btn-sm btn-info me-2" onClick={() => handleOpenModal('edit', teacher)}>Modifier</button>
                  <button className="btn btn-sm btn-danger" onClick={() => handleOpenModal('delete', teacher)}>Supprimer</button>
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
          modalType === 'add' ? 'Ajouter un enseignant' :
          modalType === 'edit' ? 'Modifier un enseignant' :
          modalType === 'delete' ? 'Confirmer la suppression' : ''
        }
        body={
          modalType === 'delete' ? (
            <p>Es-tu sûr de vouloir supprimer {selectedTeacher?.firstName} {selectedTeacher?.lastName} ?</p>
          ) : (
            <form>
              <div className="mb-3">
                <label className="form-label">Nom</label>
                <input type="text" className="form-control"
                  value={selectedTeacher?.lastName || ''}
                  onChange={(e) => setSelectedTeacher(prev => ({ ...prev!, lastName: e.target.value }))} />
              </div>
              <div className="mb-3">
                <label className="form-label">Prénom</label>
                <input type="text" className="form-control"
                  value={selectedTeacher?.firstName || ''}
                  onChange={(e) => setSelectedTeacher(prev => ({ ...prev!, firstName: e.target.value }))} />
              </div>
              <div className="mb-3">
                <label className="form-label">Email Pro</label>
                <input type="email" className="form-control"
                  value={selectedTeacher?.emailPro || ''}
                  onChange={(e) => setSelectedTeacher(prev => ({ ...prev!, emailPro: e.target.value }))} />
              </div>
              <div className="mb-3">
                <label className="form-label">Email Perso</label>
                <input type="email" className="form-control"
                  value={selectedTeacher?.emailPerso || ''}
                  onChange={(e) => setSelectedTeacher(prev => ({ ...prev!, emailPerso: e.target.value }))} />
              </div>
              <div className="mb-3">
                <label className="form-label">Téléphone</label>
                <input type="text" className="form-control"
                  value={selectedTeacher?.phoneNumber || ''}
                  onChange={(e) => setSelectedTeacher(prev => ({ ...prev!, phoneNumber: e.target.value }))} />
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

export default Teachers;
