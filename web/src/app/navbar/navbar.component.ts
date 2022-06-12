/**
 * Navbar Component
 *
 * @author Juan Esteban Velasquez , Juan Pablo Toro Hurtado
 * @version 1.0.0
 * @since 1.0.0
 */

import { Component, OnInit } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/compat/auth';
import { Router } from '@angular/router';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  userLogged = this.authService.getUserLogged();
  disabled: boolean = false;
  btnlogout = document.querySelector('#btnlogout') as HTMLElement;

  constructor(
    public authService: ServiceService,
    private route: Router,
    private afAuth: AngularFireAuth
  ) {}

  ngOnInit(): void {
    this.traerdatos();
  }

  /**
   * Trae los datos del usuario logueado
   */
  traerdatos() {
    this.userLogged.subscribe((value) => {
      if (value?.email == undefined) {
        this.disabled = true;
      } else {
        this.disabled = false;
      }
    });
  }

  /**
   * Redirige a la pagina de login
   */
  login() {
    this.route.navigate(['login']);
  }

  /**
   * Cierra la sesion del usuario
   */
  logout(): void {
    this.afAuth.signOut();
    setTimeout(() => {
      window.location.reload();
    }, 400);
    this.ocultar();

  }
  /**
   * Oculta el boton de logout
   */
  ocultar(){
     this.btnlogout.remove();
  }
}
