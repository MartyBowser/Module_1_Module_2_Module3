<template>
    <!-- Make sure you have only one root html element inside the template tag -->
  <div class="main">
      <!-- <input type=text v-model="myText" />
      <h2>{{myText}}</h2> -->

      <h2>Product Review for {{name}}</h2>
      <p class="description">{{description}}</p>
      <div class="well-display">
          <div class="well">
            <span class="amount">{{averageRating}}</span>
            Average Rating
          </div>
          <div class="well">
            <span class="amount">{{numberOf1StarReviews}}</span>
            1 Star Review
          </div>
          <div class="well">
            <span class="amount">{{numberOf2StarReviews}}</span>
            2 Star Review
          </div>
          <div class="well">
            <span class="amount">{{numberOf3StarReviews}}</span>
            3 Star Review
          </div>
          <div class="well">
            <span class="amount">{{numberOf4StarReviews}}</span>
            4 Star Review
          </div>
       </div>
      <!-- this is how we do a conditional class -->
      <div class="review" 
            v-bind:class="{classFavorited: review.favorite}" 
            v-for="review in reviews" v-bind:key="review.reviewer">
            <h4>{{review.reviewer}}</h4>
            <div class="rating">
                <img
                 v-for="n in review.rating"
                 v-bind:key="n"
                 src="../assets/star.png" 
                 class="ratingStar" />
            </div>
            <h3>{{review.title}}</h3>
            <p>
                {{review.review}}
            </p>
            <p>
                Favorite?
                <input type="checkbox" v-model="review.favorite" />
            </p>
        </div>
  </div>
</template>

<script>
export default {
    //This is a javascript comment
    name: 'product-review',
    data() {
        return {
            myText: "Hello World",
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
        }
    },
    computed: {
        averageRating() {
            let sum = 0;
            for(let review of this.reviews) {
                sum += review.rating;
            }

            return sum / this.reviews.length;
        },
        numberOf1StarReviews() {
            let counter = 0;
            for(let review of this.reviews) {
                if(review.rating === 1) {
                    counter++;
                }
            }

            return counter;
        },
        numberOf2StarReviews() {
            let counter = 0;
            for(let review of this.reviews) {
                if(review.rating === 2) {
                    counter++;
                }
            }

            return counter;
        },
        numberOf3StarReviews() {
            let counter = 0;
            for(let review of this.reviews) {
                if(review.rating === 3) {
                    counter++;
                }
            }

            return counter;
        },
        numberOf4StarReviews() {
            let counter = 0;
            for(let review of this.reviews) {
                if(review.rating === 4) {
                    counter++;
                }
            }

            return counter;
        }
    }
}
</script>

<style scoped>
.classFavorited{
    background-color:yellow;
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
</style>

