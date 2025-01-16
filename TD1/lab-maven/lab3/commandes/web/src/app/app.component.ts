import { Component } from '@angular/core';
import {WebController} from '../controller/WebController';


@Component({
  selector: 'app-root',
  template: `
    <h1>{{ title }}</h1>

  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string = '';

  constructor(private webController: WebController) {
    this.fetchData();
  }

  async fetchData(): Promise<void> {
    try {
      this.title = await this.webController.fetchResponse();
    } catch (error) {
      console.error('Erreur lors de la récupération des données', error);
    }
  }
}
