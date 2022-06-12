describe('Click boton iniciar sesion', () => {
  it('passes', () => {
    cy.visit('http://localhost:4200/preguntas')
    cy.contains('Inicia sesión').click();
  })
})
