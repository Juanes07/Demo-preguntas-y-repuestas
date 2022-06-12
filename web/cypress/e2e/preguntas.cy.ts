describe('Preguntas', () => {
  it('passes', () => {
    cy.visit('http://localhost:4200/preguntas');
    cy.contains('Todas las preguntas')
    cy.contains('Preguntas')
  })
})
