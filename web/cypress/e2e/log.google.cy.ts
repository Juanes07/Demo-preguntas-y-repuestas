import { Input } from "@angular/core"

describe('recuperar contraseña', () => {
  it('passes', () => {
    cy.visit('http://localhost:4200/login')
    cy.contains('Google').click()
  })
})
