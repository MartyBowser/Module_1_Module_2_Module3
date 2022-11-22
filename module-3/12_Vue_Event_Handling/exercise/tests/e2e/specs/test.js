// https://docs.cypress.io/api/introduction/api.html\

describe('Event Handling Exercise', () => {
  beforeEach(() => {
    cy.visit('/');
  })

  describe('Step One Tests: New User Form', () => {
    it('should be hidden by default', () => {
      cy.get('#frmAddNewUser').should('not.be.visible');
    });
    it('should be toggled by Add New User button', () => {
      cy.contains('button', 'Add New User').click();
      cy.get('#frmAddNewUser').should('be.visible');
      cy.contains('button', 'Add New User').click();
      cy.get('#frmAddNewUser').should('not.be.visible');
    });

    describe('Save New User Tests', () => {
      beforeEach(() => {
        cy.contains('button', 'Add New User').click();

        cy.get('input[name=firstName]').type('Bobbert');
        cy.get('input[name=lastName]').type('Toddson');
        cy.get('input[name=username]').type('BobbToddson');
        cy.get('input[name=emailAddress]').type('test@test.test');

        cy.contains('button', 'Save User').click();
      });
      it('should submit form to add to users array', () => {
        cy.get('#tblUsers tbody').find('tr').should('have.length', 8);
      });
      it('should add the new user form values to the correct fields', () => {
        cy.get('td #7').should('have.value', '7');
        cy.contains('td', 'Bobbert').should('not.be.empty');
        cy.contains('td', 'Toddson').should('not.be.empty');
        cy.contains('td', 'BobbToddson').should('not.be.empty');
        cy.contains('td', 'test@test.test').should('not.be.empty');
      });
      it('should clear the add new user form after saving a new user', () => {
        cy.get('td #7').should('have.value', '7');
        cy.get('input[name=firstName]').should('be.empty');
        cy.get('input[name=lastName]').should('be.empty');
        cy.get('input[name=username]').should('be.empty');
        cy.get('input[name=emailAddress]').should('be.empty');
      });
    });
  });

  describe('Step Two Tests: Enable/Disable Action Button', () => {
    before(() => {
      it('should display text "Disable" if user\'s status is "Active"', () => {
        cy.contains('tr', 'jsmith').within(() => {
          cy.contains('td', 'Active').should('exist');
          cy.get('td button')
            .contains('Disable').should('exist')
        });
      });
      it('should display text "Enable" if user\'s status is "Disabled"', () => {
        cy.contains('tr', 'gbest').within(() => {
          cy.contains('td', 'Disabled').should('exist');
          cy.get('td button')
            .contains('Enable').should('exist')
        });
      });
    });
    it('should call flipStatus(id) method when clicked and change user\'s status', () => {
      cy.contains('tr', 'jsmith').within(() => {
        cy.contains('td', 'Active').should('exist');
        cy.get('td button')
          .contains('Disable').click(); 
      });
      cy.contains('tr', 'jsmith').within(() => {
        cy.contains('td', 'Disabled').should('exist');
        cy.get('td button')
          .contains('Enable').should('exist')
      });
      
    });
  });

  describe('Step Three Tests: Disable, Enable, and Delete Selected Users', () => {
    it('should toggle Disable, Enable, and Delete buttons when rows in the user table are checked/unchecked', () => {
      cy.get('.all-actions').find('button').should('be.disabled');
      cy.get('#4').check();
      cy.get('.all-actions button').should('not.be.disabled');
      cy.get('#4').uncheck();
      cy.get('.all-actions').find('button').should('be.disabled');
      cy.get('#1').check();
      cy.get('.all-actions button').should('not.be.disabled');
    });
    it('should enable selected users when enable button is clicked', () => {
      cy.get('.disabled').within(() => {
        cy.get('input[type=checkbox]').click({multiple: true});
      });
      cy.get('.all-actions').contains('Enable Users').click();
      cy.get('.disabled').should('not.exist');
    });
    it('should disable selected users when disable button is clicked', () => {
      cy.get('#1').check();
      cy.get('#4').check();
      cy.get('.all-actions').contains('Disable Users').click();
      cy.get('.disabled').find('#1').should('exist');
      cy.get('.disabled').find('#4').should('exist');
    });
    it('should delete users when delete button is hit', () => {
      cy.get('tbody tr').should('have.length', 7);      
      cy.get('#1').check();
      cy.get('#4').check();
      cy.get('.all-actions').contains('Delete Users').click();
      cy.get('tbody tr').should('have.length', 5);
    });
  });

  describe('Step Four Tests: Select All Checkbox', () => {
    it('should check all user checkboxes when selectAll checkbox is checked', () => {
      cy.get('#selectAll').check();
      cy.get('input[type=checkbox]:not(:checked)').should('not.exist');
    });
    it('should uncheck all user checkboxes when selectAll checkbox is unchecked', () => {
      cy.get('#selectAll').check();
      cy.get('input[type=checkbox]:not(:checked)').should('not.exist');
      cy.get('#selectAll').uncheck();
      cy.get('input[type=checkbox]:checked').should('not.exist');
    });
    it('should check/uncheck all boxes if some are already selected', () => {
      cy.get('#1, #4').check();
      cy.get('#selectAll').check();
      cy.get('input[type=checkbox]:not(:checked)').should('not.exist');
      cy.get('#selectAll').uncheck();
      cy.get('input[type=checkbox]:checked').should('not.exist');
    })
    it('should check selectAll checkbox if all user checkboxes are checked individually', () => {
      cy.get('#selectAll').should('not.be.checked')
      cy.get('input[type=checkbox]:not(#selectAll)').check({multiple: true});
      cy.get('#selectAll').should('be.checked');
    });
  });
});
