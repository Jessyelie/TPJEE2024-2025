import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class WebController {
  async fetchResponse(): Promise<string> {
    const response = await fetch('http://localhost:8080/api/commandes');
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    return response.text(); // Récupère la réponse comme texte brut
  }
}
