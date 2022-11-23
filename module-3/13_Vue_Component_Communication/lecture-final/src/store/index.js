import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    name: "Ghost Hunting For Dummies",
    description: "Learn how to hunt ghosts like the professionals!",
    reviews : [
        {
            reviewer: 'Malcolm Madwell',
            title: 'What a book!',
            review:
            "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language. Yes indeed, it is a book!",
            rating: 2,
            favorite: false
        },
        {
            reviewer: 'Tim Ferriss',
            title: 'Caught a ghost in less than 4 hours.',
            review:
            "It should have been called the four hour ghost hunt. That's amazing.",
            rating: 4,
            favorite: false

        }
        ]
  },
  mutations: {
    ADD_REVIEW(state, payload) {
      state.reviews.unshift(payload);
    }
  },
  actions: {
  },
  modules: {
  },
  // Strict should not be used in production code. It is used here as a
  // learning aid to warn you if state is modified without using a mutation.
  strict: true
})
