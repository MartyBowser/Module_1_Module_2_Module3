describe("Web API (POST) Exercises", () => {

  describe('Part One: CRUD Topics', () => {

    it('Step One Tests: should create new topic', () => {
      cy.visit('/add-topic')
      cy.get('input').type('This is a TEST title for a new topic');
      cy.get('button').click();
      cy.contains('This is a TEST title for a new topic');
      cy.get('.topic-list tbody tr').should('have.length', 21);
    });

    it('Step Two Tests: should update the new topic', () => {
      cy.visit('/');
      // find the new topic and edit it
      cy.contains('This is a TEST title for a new topic').then(($link) => {
        cy.visit(`/edit-topic${$link.attr("href")}`);
        cy.get('input').clear().type('Updated TEST title');
        cy.get('button').click();
        cy.contains('Updated TEST title');
      })
    });

    it('Step Three Tests: should delete the new topic', () => {
      cy.visit('/');
      cy.contains('Updated TEST title');
      cy.get('tbody tr a').last().click();
      cy.get('.topic-list tbody tr').should('have.length', 20);
    });

  });

  describe('Part Two: CRUD Messages', () => {

    it('Step One Tests: should create new message', () => {
      cy.visit('/1/add-message')
      cy.get('input[name="title"]').type('TEST TITLE');
      cy.get('input[name="messageText"]').type('TEST MESSAGE TEXT');
      cy.get('button').click();
      cy.contains('TEST TITLE');
      cy.contains('TEST MESSAGE TEXT')
      cy.get('.topic-message').should('have.length', 5);
    });

    it('Step Two Tests: should update the new message', () => {
      cy.visit('/1');
      cy.get('.btnEditMessage').last().click();
      cy.get('input[name="title"]').clear().type('UPDATED TEST TITLE');
      cy.get('input[name="messageText"]').clear().type('UPDATED TEST MESSAGE TEXT');
      cy.get('button').click();
      cy.contains('UPDATED TEST TITLE');
      cy.contains('UPDATED TEST MESSAGE TEXT')
    });

    it('Step Three Tests: should delete the new message', () => {
      cy.visit('/1');
      cy.contains('UPDATED TEST TITLE');
      cy.contains('UPDATED TEST MESSAGE TEXT');
      cy.get('.btnDeleteMessage').last().click();
      cy.get('.topic-message').should('have.length', 4);
    });

  });

});
