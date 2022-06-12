describe('Responder', () => {
  it('passes', () => {
    cy.visit('http://localhost:4200/preguntas')
    cy.contains('contestar Pregunta').click();
  })
})
