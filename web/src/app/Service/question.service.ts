import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { QuestionI } from '../models/question-i';
import { AnswerI } from '../models/answer-i';
@Injectable({
  providedIn: 'root',
})
export class QuestionService {
  push(arg0: string) {
    throw new Error('Method not implemented.');
  }


  private url: string = 'https://reto-preguntas.herokuapp.com/';


  constructor(private http: HttpClient) {}

  getPage(page: number): Observable<QuestionI[]> {
    let direction = this.url + 'api/preguntas/listar';
    return this.http.get<QuestionI[]>(direction);
  }

  getAnswer(id: any): Observable<QuestionI> {
    let direction = this.url + 'api/respuestas/listar';
    return this.http.get<QuestionI>(direction);
  }

  deleteQuestion(id: string):Observable<any>{
    return this.http.delete(this.url+'api/preguntas/eliminar/'+id);
  }

  // getQuestion(id: string): Observable<QuestionI> {
  //   let direction = this.url + 'get/' + id;
  //   return this.http.get<QuestionI>(direction);
  // }

  // getTotalPages(): Observable<number> {
  //   let direction = this.url + 'totalPages';
  //   return this.http.get<number>(direction);
  // }

  // getCountQuestions(): Observable<number> {
  //   let direction = this.url + 'countQuestions';
  //   return this.http.get<number>(direction);
  // }

  saveQuestion(question: QuestionI): Observable<any> {
    let direction = this.url + 'api/preguntas/guardar';
    return this.http.post<any>(direction, question, {
      responseType: 'text' as 'json',
    });
  }

  saveAnswer(answer: AnswerI): Observable<any> {
    let direction = this.url + 'api/respuestas/guardar';
    return this.http.post<any>(direction, answer);
  }

  // editQuestion(question: QuestionI): Observable<any> {
  //   let direction = this.url + 'update';
  //   return this.http.post<any>(direction, question);
  // }
}
