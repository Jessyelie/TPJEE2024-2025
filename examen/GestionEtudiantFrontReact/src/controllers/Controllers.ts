import { env } from "../Constants/app.constants";

function Controllers() {
  return {
    fetch: async (endpoint: string, options: RequestInit) => {
      try {
        const response = await fetch(`${env.url.back}${endpoint}`, options);
        if (!response.ok) {
          throw new Error(`Erreur: ${response.statusText}`);
        }
        return await response.json();
      } catch (error) {
        console.error("Erreur lors de la requête:", error);
        throw error;
      }
    },

    // Fonction générique pour récupérer toutes les données
    obtenirTous: async <T>(entite: string): Promise<T[]> => {
      try {
        const response = await fetch(`${env.url.back}/api/${entite.toLowerCase()}`, 
        {
          method: "GET",
          headers: { "Content-Type": "application/json" },
        });

        if (!response.ok) {
          throw new Error(`Erreur: ${response.statusText}`);
        }
        
        return await response.json();
      } catch (error) {
        console.error(`Erreur lors de la récupération des ${entite}:`, error);
        throw error;
      }
    },

    // Fonction pour récupérer un élément par son ID
    obtenirParId: async <T>(entite: string, id: number): Promise<T> => {
      try {
        const response = await fetch(`${env.url.back}/api/${entite.toLowerCase()}/${id}`, {
          method: "GET",
          headers: { "Content-Type": "application/json" },
        });

        if (!response.ok) {
          throw new Error(`Erreur: ${response.statusText}`);
        }

        return await response.json();
      } catch (error) {
        console.error(`Erreur lors de la récupération de ${entite} avec ID ${id}:`, error);
        throw error;
      }
    },

    // Fonction pour ajouter un élément
    ajouter: async <T>(entite: string, data: any): Promise<T> => {
      try {
        const response = await fetch(`${env.url.back}/api/${entite.toLowerCase()}`, {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(data),
        });

        if (!response.ok) {
          throw new Error(`Erreur: ${response.statusText}`);
        }

        return await response.json();
      } catch (error) {
        console.error(`Erreur lors de l'ajout de ${entite}:`, error);
        throw error;
      }
    },

    // Fonction pour modifier un élément existant
    modifier: async <T>(entite: string, id: number, data: any): Promise<T> => {
      try {
        const response = await fetch(`${env.url.back}/api/${entite.toLowerCase()}/${id}`, {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(data),
        });

        if (!response.ok) {
          throw new Error(`Erreur: ${response.statusText}`);
        }

        return await response.json();
      } catch (error) {
        console.error(`Erreur lors de la modification de ${entite} avec ID ${id}:`, error);
        throw error;
      }
    },

    // Fonction pour supprimer un élément
    supprimer: async (entite: string, id: number): Promise<void> => {
      try {
        const response = await fetch(`${env.url.back}/api/${entite.toLowerCase()}/${id}`, {
          method: "DELETE",
          headers: { "Content-Type": "application/json" },
        });

        if (!response.ok) {
          throw new Error(`Erreur: ${response.statusText}`);
        }
      } catch (error) {
        console.error(`Erreur lors de la suppression de ${entite} avec ID ${id}:`, error);
        throw error;
      }
    },
  };
}

export default Controllers;
