const book_name = 'Ghost Hunting for Dummies';
const description = 'Learn how to hunt ghosts like the professionals.';
const reviews = [
  {
    reviewer: 'Malcolm Madwell',
    title: 'What a book!',
    review:
    "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language. Yes indeed, it is a book!",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Caught a ghost in less than 4 hours.',
    review:
      "It should have been called the four hour ghost hunt. That's amazing.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but at the end you realize that you yourself are actually a ghost.",
    rating: 3
  }
];

/*
Three methods commonly used for selecting HTML elements from the DOM:

1. document.getElementById() - we'll use this if we have an id we can select by
2. document.querySelector() - we'll use this when we want to pass in any CSS selector and retrieve only the first 
                              element that matches
3. document.querySelectorAll() - we'll use this when we want to pass in any CSS seelector and retrieve all 
                                elements that match

Other Useful Methods:
document.createElement() - pass in the tag name of any element you want to create

.setAttribute("attributeName", "attributeValue") - creates an attribute on the element 

If we have an image, we can set the src directly
.src = "path"  

If we want to change the text, we can set the innerText directly
.innerText = "any text I want"

If we want to add a new html element appending it to an existing one
existingElement.appendChild(newElement)
*/


/**
 * Add the product name to the page title
 * Get the page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {

  document.getElementById("page-title").querySelector(".name").innerText = book_name;
}

/**
 * Add the product description to the page.
 */
function setPageDescription() {
  document.querySelector(".description").innerText = description;
}

/**
 * Display all of the reviews on the page.
 * Loop over the array of reviews and use some helper functions
 * to create the elements needed for the markup and add them to the DOM.
 */
function displayReviews() {

  const main = document.getElementById("main");

  reviews.forEach(
    (review) => {

      //I'm creating a new div element in the dom and 
      // giving it an attribute of class="review"
      const container = document.createElement("div");
      container.setAttribute("class", "review");

      //create the h4 that holds the author name
      const reviewer = document.createElement("h4");
      reviewer.innerText = review.reviewer;
      container.appendChild(reviewer);

      //create the div that holds the rating stars
      const ratingDiv = document.createElement("div");
      ratingDiv.setAttribute("class","rating");

      //create as many images as there stars in the rating
      for(let i = 0; i < review.rating; i++){
        const star = document.createElement("img");
        star.src = "img/star.png";
        star.setAttribute("class", "ratingStar");
        ratingDiv.appendChild(star);
      }
      container.appendChild(ratingDiv);

      //create the h3 to hold the title of the review
      const reviewTitle = document.createElement("h3");
      reviewTitle.innerText = review.title;
      container.appendChild(reviewTitle);

      //create the paragraph to hold the description
      const desc = document.createElement("p");
      desc.innerText = review.review;
      container.appendChild(desc);

      //add this element to the dom
      main.appendChild(container);

    }
  );

}

/**
 * Create a new h2 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {

}

/**
 * Add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {}

/**
 * Add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {}

/**
 * Add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on the page
displayReviews();
