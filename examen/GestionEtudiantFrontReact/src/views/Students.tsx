import { useState, useEffect } from 'react';
import { Classes, Student } from '../models/types';
import Controllers from '../controllers/Controllers';
import Modal from '../components/Modal';

function Students() {
  const [students, setStudents] = useState<Student[]>([]);
  const [classes, setClasses] = useState<Classes[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  const [isModalVisible, setIsModalVisible] = useState(false);
  const [selectedStudent, setSelectedStudent] = useState<any>({
    id: 0,
    lastName: '',
    firstName: '',
    emailPro: '',
    emailPerso: '',
    phoneNumber: '',
    address: '',
    archive: false // Supprime cette ligne si le champ n'existe pas
  });
  const [modalType, setModalType] = useState<'add' | 'edit' | 'delete' | null>(null);

  useEffect(() => {
    loadStudents();
  }, []);

  useEffect(() => {
    const loadClasses = async () => {
      setLoading(true);
      setError(null);

      try {
        const data = await Controllers().obtenirTous<Classes>('classes'); // Ajout du typage Student[]
        if (Array.isArray(data)) {
          setClasses(data); // Utilisation correcte de la liste reçue
        } else {
          console.warn("Format inattendu des données :", data);
          setStudents([]); // Évite d'afficher une mauvaise structure
        }
      } catch (error) {
        setError('Erreur lors du chargement des étudiants');
        console.error("Erreur lors de la récupération des étudiants :", error);
      } finally {
        setLoading(false);
      }
    };
    loadClasses()
  }, [])


  const loadStudents = async () => {
    setLoading(true);
    setError(null);

    try {
      const data = await Controllers().obtenirTous<Student>('students'); // Ajout du typage Student[]
      if (Array.isArray(data)) {
        setStudents(data); // Utilisation correcte de la liste reçue
      } else {
        console.warn("Format inattendu des données :", data);
        setStudents([]); // Évite d'afficher une mauvaise structure
      }
    } catch (error) {
      setError('Erreur lors du chargement des étudiants');
      console.error("Erreur lors de la récupération des étudiants :", error);
    } finally {
      setLoading(false);
    }
  };


  const handleOpenModal = (type: 'add' | 'edit' | 'delete', student?: Student) => {
    student && setSelectedStudent(student); // Préparer un objet vide pour l'ajout
    setModalType(type);
    setTimeout(() => setIsModalVisible(true), 0); // Correction pour éviter un problème d'asynchronicité
  };

  const handleCloseModal = () => {
    setIsModalVisible(false);
    setTimeout(() => {
      setSelectedStudent(null);
      setModalType(null);
    }, 300); // Petite attente pour éviter un affichage bizarre
  };

  const handleSave = async () => {
    if (!selectedStudent) return;

    try {
      if (modalType === 'add') {
        // Ajout d'un nouvel étudiant
        const newStudent = await Controllers().ajouter<Student>('students', selectedStudent);
        console.log(JSON.stringify(newStudent.classes as Classes))
        setStudents([...students, {...newStudent,classes:newStudent.classes as Classes}]); // Mise à jour de la liste des étudiants
      } else if (modalType === 'edit' && selectedStudent.id) {
        // Modification d'un étudiant existant
        const updatedStudent = await Controllers().modifier<Student>('students', selectedStudent.id, selectedStudent);
        setStudents(students.map(student => student.id === updatedStudent.id ? updatedStudent : student));
      }

      console.log('Sauvegarde réussie :', selectedStudent);
    } catch (error) {
      console.error('Erreur lors de la sauvegarde :', error);
    }

    handleCloseModal();
  };

  const handleDelete = async () => {
    if (!selectedStudent || !selectedStudent.id) return;

    try {
      await Controllers().supprimer('students', selectedStudent.id);
      setStudents(students.filter(student => student.id !== selectedStudent.id)); // Mise à jour de la liste
      console.log('Suppression réussie de l’étudiant :', selectedStudent);
    } catch (error) {
      console.error('Erreur lors de la suppression :', error);
    }

    handleCloseModal();
  };


  if (loading) return <div className="text-center">Chargement...</div>;
  if (error) return <div className="alert alert-danger">{error}</div>;

  return (
    <div className="container">
      <div className="d-flex justify-content-between align-items-center mb-4">
        <h1>Liste des étudiants</h1>
        <button className="btn btn-primary" onClick={() => handleOpenModal('add')}>Ajouter un étudiant</button>
      </div>
      <div className="table-responsive">
        <table className="table table-striped">
          <thead>
            <tr>
              <th>Nom</th>
              <th>Prénom</th>
              <th>Email Pro</th>
              <th>Téléphone</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {students.length > 0 ? (
              students.map((student) => (
                <tr key={student.id}>
                  <td>{student.lastName}</td>
                  <td>{student.firstName}</td>
                  <td>{student.emailPro}</td>
                  <td>{student.phoneNumber}</td>
                  <td>
                    <button className="btn btn-sm btn-info me-2" onClick={() => handleOpenModal('edit', student)}>Modifier</button>
                    <button className="btn btn-sm btn-danger" onClick={() => handleOpenModal('delete', student)}>Supprimer</button>
                  </td>
                </tr>
              ))
            ) : (
              <tr><td colSpan={5} className="text-center">Aucun étudiant trouvé</td></tr>
            )}
          </tbody>
        </table>
      </div>

      {/* Modal */}
      <Modal
        isVisible={isModalVisible}
        title={
          modalType === 'add' ? 'Ajouter un étudiant' :
            modalType === 'edit' ? 'Modifier un étudiant' :
              modalType === 'delete' ? 'Confirmer la suppression' : 'Chargement ...'
        }
        body={
          modalType === 'delete' ? (
            <p>Es-tu sûr de vouloir supprimer {selectedStudent?.firstName} {selectedStudent?.lastName} ?</p>
          ) : (
            <form>
              {/* Nom */}
              <div className="mb-3">
                <label className="form-label">Nom</label>
                <input type="text" className="form-control"
                  value={selectedStudent?.lastName || ''}
                  onChange={(e) => setSelectedStudent({ ...selectedStudent, lastName: e.target.value })} />
              </div>

              {/* Prénom */}
              <div className="mb-3">
                <label className="form-label">Prénom</label>
                <input type="text" className="form-control"
                  value={selectedStudent?.firstName || ''}
                  onChange={(e) => setSelectedStudent({ ...selectedStudent, firstName: e.target.value })} />
              </div>

              {/* Email professionnel */}
              <div className="mb-3">
                <label className="form-label">Email Pro</label>
                <input type="email" className="form-control"
                  value={selectedStudent?.emailPro || ''}
                  onChange={(e) => setSelectedStudent({ ...selectedStudent, emailPro: e.target.value })} />
              </div>
              {/* adresse*/}
              <div className="mb-3">
                <label className="form-label">Adresse</label>
                <input type="text" className="form-control"
                  value={selectedStudent?.address || ''}
                  onChange={(e) => setSelectedStudent({ ...selectedStudent, address: e.target.value })} />
              </div>
              {/* Email personnel */}
              <div className="mb-3">
                <label className="form-label">Email Perso</label>
                <input type="email" className="form-control"
                  value={selectedStudent?.emailPerso || ''}
                  onChange={(e) => setSelectedStudent({ ...selectedStudent, emailPerso: e.target.value })} />
              </div>

              {/* Téléphone */}
              <div className="mb-3">
                <label className="form-label">Téléphone</label>
                <input type="text" className="form-control"
                  value={selectedStudent?.phoneNumber || ''}
                  onChange={(e) => setSelectedStudent({ ...selectedStudent, phoneNumber: e.target.value })} />
              </div>

              {/* Sélection de la classe */}
              <div className="mb-3">
                <label className="form-label">Classe</label>
                <select className="form-select"
                  value={selectedStudent?.classe || ''}
                  onChange={(e) => setSelectedStudent({ ...selectedStudent, classe: e.target.value })}>
                  <option value="">Sélectionner une classe</option>
                  {classes.map((classe) => (
                    <option value={JSON.stringify(classe)}>{classe.name}</option>))}
                </select>
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

export default Students;
