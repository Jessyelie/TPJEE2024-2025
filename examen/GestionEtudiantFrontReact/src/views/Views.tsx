import { useState, useEffect } from 'react';
import Controllers from '../controllers/Controllers';
import Modal from '../components/Modal';

interface EntityProps<T> {
  entityName: string;
  fields: { key: keyof T; label: string; type?: string }[];
}

export function EntityManagement<T>({ entityName, fields }: EntityProps<T>) {
  const [items, setItems] = useState<T[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [selectedItem, setSelectedItem] = useState<T | null>(null);
  const [modalType, setModalType] = useState<'add' | 'edit' | 'delete' | null>(null);

  useEffect(() => {
    loadItems();
  }, []);

  const loadItems = async () => {
    setLoading(true);
    setError(null);
    try {
      const data = await Controllers().obtenirTous<T>(entityName.toLowerCase());
      setItems(Array.isArray(data) ? data : []);
    } catch (error) {
      setError(`Erreur lors du chargement des ${entityName}`);
      console.error(error);
    } finally {
      setLoading(false);
    }
  };

  const handleOpenModal = (type: 'add' | 'edit' | 'delete', item?: T) => {
    setSelectedItem(item || ({} as T));
    setModalType(type);
    setIsModalVisible(true);
  };

  const handleCloseModal = () => {
    setIsModalVisible(false);
    setTimeout(() => {
      setSelectedItem(null);
      setModalType(null);
    }, 300);
  };

  const handleSave = async () => {
    if (!selectedItem) return;
    try {
      if (modalType === 'add') {
        const newItem = await Controllers().ajouter<T>(entityName.toLowerCase(), selectedItem);
        setItems([...items, newItem]);
      } else if (modalType === 'edit') {
        const updatedItem = await Controllers().modifier<T>(entityName.toLowerCase(), (selectedItem as any).id, selectedItem);
        setItems(items.map(item => (item === selectedItem ? updatedItem : item)));
      }
    } catch (error) {
      console.error(`Erreur lors de la sauvegarde de ${entityName}`, error);
    }
    handleCloseModal();
  };

  const handleDelete = async () => {
    if (!selectedItem || !(selectedItem as any).id) return;
    try {
      await Controllers().supprimer(entityName.toLowerCase(), (selectedItem as any).id);
      setItems(items.filter(item => item !== selectedItem));
    } catch (error) {
      console.error(`Erreur lors de la suppression de ${entityName}`, error);
    }
    handleCloseModal();
  };

  return (
    <div className="container">
      <h1>{entityName}</h1>
      <button className="btn btn-primary" onClick={() => handleOpenModal('add')}>Ajouter {entityName}</button>
      {loading ? <p>Chargement...</p> : error ? <p className="text-danger">{error}</p> : (
        <table className="table table-striped">
          <thead>
            <tr>
              {fields.map(field => <th key={field.key as string}>{field.label}</th>)}
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {items.map((item, index) => (
              <tr key={index}>
                {fields.map(field => <td key={field.key as string}>{(item as any)[field.key]}</td>)}
                <td>
                  <button className="btn btn-sm btn-info me-2" onClick={() => handleOpenModal('edit', item)}>Modifier</button>
                  <button className="btn btn-sm btn-danger" onClick={() => handleOpenModal('delete', item)}>Supprimer</button>
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
          modalType === 'add' ? `Ajouter ${entityName}` :
          modalType === 'edit' ? `Modifier ${entityName}` :
          modalType === 'delete' ? `Confirmer la suppression` : ''
        }
        body={
          modalType === 'delete' ? (
            <p>Es-tu sûr de vouloir supprimer cet élément ?</p>
          ) : (
            <form>
              {fields.map(field => (
                <div className="mb-3" key={field.key as string}>
                  <label className="form-label">{field.label}</label>
                  <input
                    type={field.type || 'text'}
                    className="form-control"
                    value={(selectedItem as any)?.[field.key] || ''}
                    onChange={(e) => setSelectedItem(prev => ({ ...prev, [field.key]: e.target.value }))}
                  />
                </div>
              ))}
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


