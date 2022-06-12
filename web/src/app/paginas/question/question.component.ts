/**
 * Componente question
 *
 * @author Juan Esteban Velasquez , Juan Pablo Toro Hurtado
 * @version 1.0.0
 * @since 1.0.0
 */

import { Component, OnInit, Output,EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { MessageService } from 'primeng/api';
import { answe } from 'src/app/models/answe';
import { AnswerI } from 'src/app/models/answer-i';
import { QuestionI } from 'src/app/models/question-i';
import { QuestionService } from 'src/app/Service/question.service';
import { ServiceService } from 'src/app/Service/service.service';
import { v4 as uuidv4} from 'uuid';


@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css'],
  providers: [MessageService],
})
export class QuestionComponent implements OnInit {

  @Output() preguntaCreada = new EventEmitter();

  myuuid: string = uuidv4();
  answers: AnswerI[] | undefined;
  question: answe = {
    id:
      this.myuuid,
    userId:
      this.authService.userData.uid == undefined
        ? ''
        : this.authService.userData.uid,
    question: '',
    type: '',
    category: '',
    answers:[null],
    start: '2'
  };

  constructor(
    private modalService: NgbModal,
    private authService: ServiceService,
    private services: QuestionService,
    private toastr: ToastrService,
    private route: Router,
    private messageService: MessageService
  ) {}

  ngOnInit(): void {}

    /**
     *  Metodo que abre el modal de crear pregunta
     * @param content   contenido del modal
     */
  openVerticallyCentered(content: any) {
    this.modalService.open(content, { centered: true });
  }

  /**
   *   Metodo que crea una pregunta
   * @param question pregunta a crear
   */
  saveQuestion(question: QuestionI): void {
    if(question.type && question.category){
     this.modalService.dismissAll();
     this.services.saveQuestion(question).subscribe({
       next: (v) => {
         if (v) {
           this.messageService.add({
             severity: 'success',
             summary: 'Se ha agregado la pregunta',

            });
            this.preguntaCreada.emit("pregunta creada");
            this.clearForm();
        } else {

        }
      },
      error: (e) =>
      this.toastr.error(e.mesaje, 'Fail', {
        timeOut: 3000,
      }),
      complete: () => console.info('complete'),
    });
  }else{

    this.messageService.add({
      severity: 'error',
      summary: 'Rectifique los datos',
      detail: '(Campos Vacios)-Intente de Nuevo',
    });
  }
  }

  /**
   * Metodo que limpia el formulario
   */
  clearForm(){
    this.question = {id:
      this.authService.userData.uid == undefined
        ? ''
        : this.authService.userData.uid,
    userId:
      this.authService.userData.uid == undefined
        ? ''
        : this.authService.userData.uid,
    question: '',
    type: '',
    category: '',
    answers:[null],
    start: '2'}
  }
}
