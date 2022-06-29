import { Role } from "./Role.model";

export class Utilisateur
{

  nom!:string;
  prenom!:string;
  username!:string;
  password!:number;
  mail!: string;

  role!:Role;


}
