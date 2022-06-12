/**
 * Componente registro
 *
 * @author Juan Esteban Velasquez , Juan Pablo Toro Hurtado
 * @version 1.0.0
 * @since 1.0.0
 */


import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService, Message } from 'primeng/api';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.scss'],
  providers: [MessageService],
})
export class RegistroComponent implements OnInit {
  mostrar: Boolean = false;
  val1: number = 3;

  public form: FormGroup = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(8)]],
    rating: ['', []],
  });

  constructor(
    private formBuilder: FormBuilder,
    private messageService: MessageService,
    private authService: ServiceService,
    private route: Router
  ) {}

  ngOnInit(): void {}

  /**
   * Metodo para registrar un usuario
   */
  crearUsuario() {
    this.mostrar = !this.mostrar;
    this.authService
      .loginRegistre(this.form.value.email, this.form.value.password)
      .then((res) => {
        if (res) {
          this.messageService.add({
            severity: 'success',
            summary: '!Exitoso¡',
            detail: 'Usuario Creado, valide su correo para poder iniciar sesión',
          });
          this.authService.verificar();
          setTimeout(() => {
            this.route.navigate(['preguntas']);
          }, 5000);
        } else {
          this.messageService.add({
            severity: 'error',
            summary: 'Usuarios Registrado',
            detail: 'Por favor intente con otro correo',
          });
        }

        this.mostrar = !this.mostrar;
      });
  }
  /**
   * Metodo para iniciar sesion con google
   */
  ingresarGoogle() {
    this.mostrar = !this.mostrar;
    this.authService
      .loginGoogle(this.form.value.email, this.form.value.password)
      .then((res) => {
        this.mostrar = !this.mostrar;
      });
  }
  /**
   * Metodo para obtener la informacion del usuario
   */
  getUserLogged() {
    this.authService.getUserLogged().subscribe((res) => {
    });
  }
  /**
   * Metodo para redireccionar a la pagina de preguntas
   */
  preguntasHome() {
    this.route.navigate(['preguntas']);
  }

  //TODO: Utilidades
  showSuccess() {
    this.messageService.add({
      severity: 'success',
      summary: 'Success',
      detail: 'Message Content',
    });
  }
  showInfo() {
    this.messageService.add({
      severity: 'info',
      summary: 'Info',
      detail: 'Message Content',
    });
  }

  spinner() {
    this.mostrar = !this.mostrar;
  }
}
