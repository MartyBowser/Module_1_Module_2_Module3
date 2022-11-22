<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div v-on:click="displayMessage('hello')" class="well">
        <span class="amount">{{ averageRating }}</span>
        Average Rating
      </div>

      <div class="well">
        <span class="amount">{{ numberOfOneStarReviews }}</span>
        1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfTwoStarReviews }}</span>
        2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfThreeStarReviews }}</span>
        3 Star Review{{ numberOfThreeStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfFourStarReviews }}</span>
        4 Star Review{{ numberOfFourStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfFiveStarReviews }}</span>
        5 Star Review{{ numberOfFiveStarReviews === 1 ? '' : 's' }}
      </div>
    </div>

    <a href="#" v-on:click.prevent="showForm = !showForm">{{showForm ? 'Hide Form' : 'Show Form' }}</a>

    <form v-if="showForm === true" v-on:submit.prevent="addNewReview()">
      <div class="form-element">
          <label for="reviewer">Reviewer:</label>
          <input id="reviewer" type="text" v-model="newReview.reviewer" />
      </div>
      <div class="form-element">
          <label for="title">Title:</label>
          <input id="title" type="text" v-model="newReview.title" />
      </div>
      <div class="form-element">
          <label for="rating">Rating:</label>
          <img src="../assets/star.png" class="unSelectedStar" v-bind:class="{selectedStar: newReview.rating >= 1 }" v-on:click="setRating(1)" />
          <img src="../assets/star.png" class="unSelectedStar" v-bind:class="{ selectedStar: newReview.rating >= 2 }" v-on:click="setRating(2)" />
          <img src="../assets/star.png" class="unSelectedStar" v-bind:class="{ selectedStar: newReview.rating >= 3 }" v-on:click="setRating(3)"/>
          <img src="../assets/star.png" class="unSelectedStar" v-bind:class="{ selectedStar: newReview.rating >= 4 }" v-on:click="setRating(4)"/>
          <img src="../assets/star.png" class="unSelectedStar" v-bind:class="{ selectedStar: newReview.rating >= 5 }" v-on:click="setRating(5)" />
      </div>
      <div class="form-element">
          <label for="review">Review:</label>
          <textarea id="review" v-model="newReview.review"></textarea>
      </div>

      <input type="submit" value="Save" />
      <input v-on:click="resetForm()" type="button" value="Cancel" />
    </form>

    <div
      class="review"
      v-bind:class="{ favorited: review.favorited }"
      v-for="review in reviews"
      v-bind:key="review.id"
    >
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          v-bind:title="review.rating + ' Star Review'"
          class="ratingStar"
          v-for="n in review.rating"
          v-bind:key="n"
        />
      </div>
      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>

      <p>
        Favorite?
        <input type="checkbox" v-model="review.favorited" />
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-review",
  data() {
    return {
      showForm: false,
      newReview: {},
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
    };
  },
  methods: {
    displayMessage(message) {
      alert(message);
    },
    addNewReview(){
      this.newReview.rating = Number.parseInt(this.newReview.rating);
      this.reviews.unshift(this.newReview);
      this.resetForm();
    },
    resetForm() {
      this.newReview = {};
      this.showForm = false;
    },
    setRating(value){
      console.log(value);
      this.newReview.rating = Number.parseInt(value);
    }
  },
  computed: {
    averageRating() {
      let sum = this.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / this.reviews.length).toFixed(2);
    },
    numberOfOneStarReviews() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === 1);
      }, 0);
    },
    numberOfTwoStarReviews() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === 2);
      }, 0);
    },
    numberOfThreeStarReviews() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === 3);
      }, 0);
    },
    numberOfFourStarReviews() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === 4);
      }, 0);
    },
    numberOfFiveStarReviews() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === 5);
      }, 0);
    }
  }
};
</script>

<style scoped>
.unSelectedStar {
  width: 25px;
  height: 25px;
}
.unSelectedStar:hover {
  width: 50px;
  height: 50px;
}
.selectedStar{
  width:50px;
  height:50px;
}
div.main {
  margin: 1rem 0;
}

div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review.favorited {
  background-color: lightyellow;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}

div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input, div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
form > input[type=button] {
  width: 100px;
}
form > input[type=submit] {
  width: 100px;
  margin-right: 10px;
}
</style>

