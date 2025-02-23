package com.isi.dev.services.Service;


import com.isi.dev.services.Entity.*;
import com.isi.dev.services.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EcoleService {


    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final AdministrativeAgentRepository administrativeAgentRepository;
    private final ClassesRepository classesRepository;
    private final RegistrationsRepository registrationsRepository;
    private final CoursesRepository coursesRepository;
    private final SubjectsRepository subjectsRepository;
    private final TeacherRepository teacherRepository;
    private final SessionsRepository sessionsRepository;
    private final AcademicYearRepository academicYearRepository;
    private final SectorsRepository sectorsRepository;
    private final ProgramRepository programRepository;
    private final KindRepository kindRepository;

    // CRUD pour User
    public List<AppUser> trouverTousLesUsers() {
        return userRepository.findAll();
    }

    public Optional<AppUser> trouverUserParId(Long id) {
        return userRepository.findById(id);
    }

    public AppUser ajouterUser(AppUser user) {

        return userRepository.save(user);
    }

    public AppUser modifierUser(AppUser user) {
        return userRepository.save(user);
    }

    public void supprimerUser(Long id) {
        userRepository.deleteById(id);
    }

    // CRUD pour Student
    public List<Student> trouverTousLesEtudiants() {
        return studentRepository.findAll();
    }

    public Optional<Student> trouverEtudiantParId(Long id) {
        return studentRepository.findById(id);
    }

    public Student ajouterEtudiant(Student student) {
        return studentRepository.save(student);
    }

    public Student modifierEtudiant(Student student) {
        return studentRepository.save(student);
    }

    public void supprimerEtudiant(Long id) {
        studentRepository.deleteById(id);
    }

    // CRUD pour AdministrativeAgent
    public List<AdministrativeAgent> trouverTousLesAgentsAdministratifs() {
        return administrativeAgentRepository.findAll();
    }

    public Optional<AdministrativeAgent> trouverAgentAdministratifParId(Long id) {
        return administrativeAgentRepository.findById(id);
    }

    public AdministrativeAgent ajouterAgentAdministratif(AdministrativeAgent agent) {
        return administrativeAgentRepository.save(agent);
    }

    public AdministrativeAgent modifierAgentAdministratif(AdministrativeAgent agent) {
        return administrativeAgentRepository.save(agent);
    }

    public void supprimerAgentAdministratif(Long id) {
        administrativeAgentRepository.deleteById(id);
    }

    // Et ainsi de suite pour chaque entité...

    // Exemple pour les Classes
    public List<Classes> trouverToutesLesClasses() {
        return classesRepository.findAll();
    }

    public Optional<Classes> trouverClasseParId(Long id) {
        return classesRepository.findById(id);
    }

    public Classes ajouterClasse(Classes classe) {
        return classesRepository.save(classe);
    }

    public Classes modifierClasse(Classes classe) {
        return classesRepository.save(classe);
    }

    public void supprimerClasse(Long id) {
        classesRepository.deleteById(id);
    }

    // CRUD pour Registrations
    public List<Registrations> trouverToutesLesInscriptions() {
        return registrationsRepository.findAll();
    }

    public Optional<Registrations> trouverInscriptionParId(Long id) {
        return registrationsRepository.findById(id);
    }

    public Registrations ajouterInscription(Registrations registration) {
        return registrationsRepository.save(registration);
    }

    public Registrations modifierInscription(Registrations registration) {
        return registrationsRepository.save(registration);
    }

    public void supprimerInscription(Long id) {
        registrationsRepository.deleteById(id);
    }

    // CRUD pour Courses
    public List<Courses> trouverTousLesCours() {
        return coursesRepository.findAll();
    }

    public Optional<Courses> trouverCoursParId(Long id) {
        return coursesRepository.findById(id);
    }

    public Courses ajouterCours(Courses course) {
        return coursesRepository.save(course);
    }

    public Courses modifierCours(Courses course) {
        return coursesRepository.save(course);
    }

    public void supprimerCours(Long id) {
        coursesRepository.deleteById(id);
    }

    // CRUD pour Subjects
    public List<Subjects> trouverToutesLesMatières() {
        return subjectsRepository.findAll();
    }

    public Optional<Subjects> trouverMatiereParId(Long id) {
        return subjectsRepository.findById(id);
    }

    public Subjects ajouterMatiere(Subjects subject) {
        return subjectsRepository.save(subject);
    }

    public Subjects modifierMatiere(Subjects subject) {
        return subjectsRepository.save(subject);
    }

    public void supprimerMatiere(Long id) {
        subjectsRepository.deleteById(id);
    }

    // CRUD pour Teachers
    public List<Teacher> trouverTousLesEnseignants() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> trouverEnseignantParId(Long id) {
        return teacherRepository.findById(id);
    }

    public Teacher ajouterEnseignant(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher modifierEnseignant(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void supprimerEnseignant(Long id) {
        teacherRepository.deleteById(id);
    }

    // CRUD pour Sessions
    public List<Sessions> trouverToutesLesSessions() {
        return sessionsRepository.findAll();
    }

    public Optional<Sessions> trouverSessionParId(Long id) {
        return sessionsRepository.findById(id);
    }

    public Sessions ajouterSession(Sessions session) {
        return sessionsRepository.save(session);
    }

    public Sessions modifierSession(Sessions session) {
        return sessionsRepository.save(session);
    }

    public void supprimerSession(Long id) {
        sessionsRepository.deleteById(id);
    }

    // CRUD pour AcademicYear
    public List<AcademicYear> trouverToutesLesAnneesAcademiques() {
        return academicYearRepository.findAll();
    }

    public Optional<AcademicYear> trouverAnneeAcademiqueParId(Long id) {
        return academicYearRepository.findById(id);
    }

    public AcademicYear ajouterAnneeAcademique(AcademicYear academicYear) {
        return academicYearRepository.save(academicYear);
    }

    public AcademicYear modifierAnneeAcademique(AcademicYear academicYear) {
        return academicYearRepository.save(academicYear);
    }

    public void supprimerAnneeAcademique(Long id) {
        academicYearRepository.deleteById(id);
    }

    // CRUD pour Sectors
    public List<Sectors> trouverTousLesSecteurs() {
        return sectorsRepository.findAll();
    }

    public Optional<Sectors> trouverSecteurParId(Long id) {
        return sectorsRepository.findById(id);
    }

    public Sectors ajouterSecteur(Sectors sector) {
        return sectorsRepository.save(sector);
    }

    public Sectors modifierSecteur(Sectors sector) {
        return sectorsRepository.save(sector);
    }

    public void supprimerSecteur(Long id) {
        sectorsRepository.deleteById(id);
    }

    // CRUD pour Program
    public List<Program> trouverTousLesProgrammes() {
        return programRepository.findAll();
    }

    public Optional<Program> trouverProgrammeParId(Long id) {
        return programRepository.findById(id);
    }

    public Program ajouterProgramme(Program program) {
        return programRepository.save(program);
    }

    public Program modifierProgramme(Program program) {
        return programRepository.save(program);
    }

    public void supprimerProgramme(Long id) {
        programRepository.deleteById(id);
    }

    // CRUD pour Kind
    public List<Kind> trouverTousLesTypes() {
        return kindRepository.findAll();
    }

    public Optional<Kind> trouverTypeParId(Long id) {
        return kindRepository.findById(id);
    }

    public Kind ajouterType(Kind kind) {
        return kindRepository.save(kind);
    }

    public Kind modifierType(Kind kind) {
        return kindRepository.save(kind);
    }

    public void supprimerType(Long id) {
        kindRepository.deleteById(id);
    }

    public Optional<AppUser> trouverParLogin(String login) {
        return userRepository.findByEmailPro(login);
    }


}
