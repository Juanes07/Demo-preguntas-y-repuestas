/**
 * Componente login
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
import { AngularFireAuth } from '@angular/fire/compat/auth';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [MessageService],
})
export class LoginComponent implements OnInit {
  mostrar: Boolean = false;
  mostrar2: Boolean = false;
  val1: number = 3;
  displayModal: boolean = false;
  email: any = '';

  public form: FormGroup = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(10)]],
    rating: ['', []],
  });
  public form2: FormGroup = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
  });

  constructor(
    private formBuilder: FormBuilder,
    private messageService: MessageService,
    private authService: ServiceService,
    private route: Router,
    private afAuth: AngularFireAuth,
  ) {}

  ngOnInit(): void {}

  /**
   * Metodo para iniciar sesion
   */
  ingresar() {
    this.mostrar = !this.mostrar;
    this.authService
      .login(this.form.value.email, this.form.value.password)
      .then((res) => {
        if (res == undefined) {
          this.messageService.add({
            severity: 'error',
            summary: 'Rectifique los datos',
            detail: 'Clave o Usuario incorrecto, Intente de Nuevo',
          });
        } else {
          this.messageService.add({
            severity: 'success',
            summary: 'Bienvenido',
            detail: 'Disfruta de tu estadía',
          });
          this.route.navigate(['preguntas']);
        }

        this.mostrar = !this.mostrar;
      });
  }

  /**
   * Metodo para Iniciar sesion con google
   */
  ingresarGoogle() {
    this.mostrar = !this.mostrar;
    this.authService
      .loginGoogle(this.form.value.email, this.form.value.password)
      .then((res) => {
        if (res) {
          this.messageService.add({
            severity: 'success',
            summary: 'Bienvenido',
            detail: 'Disfruta de tu estadía',
          });
          setTimeout(() => {
            this.route.navigate(['preguntas']);
          }, 3000);

        } else {
          this.messageService.add({
            severity: 'error',
            summary: 'Rectifique los datos',
            detail: 'Clave o Usuario incorrecto, Intente de Nuevo',
          });

        }
        this.mostrar = !this.mostrar;
      });
  }

  /**
   * Metodo para obtener informacion del usuario
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
  showError() {}
  spinner() {
    this.mostrar = !this.mostrar;
  }

  showModalDialog() {
    this.displayModal = true;
  }

  /**
   * Metodo para enviar correo para recuperar contraseña
   */
  recuperarEmail() {
    try {
      this.mostrar2 = !this.mostrar2;
      this.authService.resetPassword(this.form2.value.email).then((res) => {
        this.displayModal = false;
        this.messageService.add({
          severity: 'success',
          summary: '!Exitoso¡',
          detail: 'Revisa tu bandeja de entrada',
        });
      });
      this.mostrar2 = !this.mostrar2;
    } catch (error) {}
  }
}
