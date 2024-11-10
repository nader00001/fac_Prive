import { Component } from '@angular/core';
import { AdminService } from '../../../../auth/services/admin/admin.service';

@Component({
  selector: 'app-actualite',
  templateUrl: './actualite.component.html',
  styleUrl: './actualite.component.scss'
})
export class ActualiteComponent {
  actualite = {
    sujet: '',
    date: Date
  };
  message: string = '';

  constructor(private actualiteService: AdminService) {}



  onSubmit(): void {
    this.actualiteService.addActualite(this.actualite).subscribe(
      response => {
        this.message = 'Actualité ajoutée avec succès!';
        this.actualite = { sujet: '', date: Date }; // Réinitialiser le formulaire après envoi
      },
      error => {
        this.message = 'Une erreur est survenue lors de l\'ajout de l\'actualité.';
      }
    );
  }
}
