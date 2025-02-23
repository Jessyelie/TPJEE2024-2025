export interface User {
  id?: number;
  emailPro: string;
  token: string;
}

export interface Student {
  id?: number;
  firstName: string;
  lastName: string;
  emailPro: string;
  emailPerso: string;
  phoneNumber: string;
  address: string;
  archive: boolean;
  registrationNu: string;
  classes?: Classes;
}

export interface AdministrativeAgent {
  id?: number;
  firstName: string;
  lastName: string;
  emailPro: string;
  emailPerso: string;
  phoneNumber: string;
  address: string;
  archive: boolean;
}

export interface Classes {
  id?: number;
  name: string;
  description: string;
  archive: boolean;
  sector: Sectors;
  // students?: Student[];
}

export interface Registrations {
  id?: number;
  date: string;
  description: string;
  archive: boolean;
}

export interface Courses {
  id?: number;
  name: string;
  description: string;
  archive: boolean;
}

export interface Subjects {
  id?: number;
  name: string;
  description: string;
  archive: boolean;
}

export interface Teacher {
  id?: number;
  firstName: string;
  lastName: string;
  emailPro: string;
  emailPerso: string;
  phoneNumber: string;
  address: string;
  archive: boolean;
}

export interface Sessions {
  id?: number;
  name: string;
  beginDate: string; 
  endDate: string;   
  description: string;
  archive: boolean;
}

export interface AcademicYear {
  id?: number;
  name: string;
  description: string;
  archive: boolean;
}

export interface Sectors {
  id?: number;
  name: string;
  archive: boolean;
}

export interface Program {
  id?: number;
  name: string;
  description: string;
  archive: boolean;
}

export interface Kind {
  id?: number;
  name: string;
  description: string;
  archive: boolean;
}


