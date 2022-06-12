describe('Registro', () => {
  it('passes', () => {
    cy.visit('http://localhost:4200/registro')
    cy.contains('Preguntas').click()
  })
})
