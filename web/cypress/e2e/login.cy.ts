
describe('Login test', () => {
  it('passes', () => {
    cy.visit('http://localhost:4200/login')
    cy.contains('Registrate').click()
  })
})
