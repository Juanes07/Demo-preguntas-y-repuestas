import { ToastrService } from 'ngx-toastr';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AnswerI } from 'src/app/models/answer-i';
import { QuestionService } from 'src/app/Service/question.service';
import { MessageService } from 'primeng/api';
import { ServiceService } from 'src/app/Service/service.service';
import { Component, EventEmitter, Input, OnInit,Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { QuestionI } from 'src/app/models/question-i';

@Component({
  selector: 'app-answer',
  templateUrl: './answer.component.html',
  styleUrls: ['./answer.component.css'],
  providers: [MessageService],
})
export class AnswerComponent implements OnInit {
  public form: FormGroup = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(10)]],
    rating: ['', []],
  });

  @Output() respuestaCreada = new EventEmitter();

  @Input() item!: QuestionI;



  constructor(
    private modalService: NgbModal,
    private services: QuestionService,
    private toastr: ToastrService,
    private route: Router,
    private formBuilder: FormBuilder,
    private messageService: MessageService,
    public authService: ServiceService
  ) {}


  answer: AnswerI = {
    userId: '',
    questionId: '',
    answer: '',
    position: 0,
  };

  ngOnInit(): void {

  }

  openVerticallyCentered(content: any) {
    this.modalService.open(content, { centered: true });
  }

  saveAnswer(): void {
    this.answer.userId = this.answer.userId;
    this.answer.questionId = this.answer.questionId
    this.services.saveAnswer(this.answer).subscribe({
      next: (v) => {
        if (v) {
          this.modalService.dismissAll();
          this.messageService.add({
            severity: 'success',
            summary: 'Se ha agregado la respuesta',
          });
          this.respuestaCreada.emit();
          // this.clearForm();
        }
      },
      error: (e) =>
        this.messageService.add({
          severity: 'error',
          summary: 'Rectifique los datos',
          detail: '(Campos Vacios)-Intente de Nuevo',
        }),
      complete: () => console.info('complete'),
    });
  }


  // clearForm(){
  //   this.answer = { questionId:
  //     this.authService.userData.uid == undefined
  //       ? ''
  //       : this.authService.userData.uid,
  //     userId:
  //     this.authService.userData.uid == undefined
  //       ? ''
  //       : this.authService.userData.uid,
  //       answer: '',
  //       position: 0,
  //   }
  // }

}
