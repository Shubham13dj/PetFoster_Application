import React from 'react';
import '../styles/blog.css';

function BlogPage() {
  return (
    <div className="blog-container">
      <h1 className="main-heading">🐾 Welcome to Our Pet Foster Blog! 🐾</h1>
      <p className="intro-text">
        We’re excited to share with you helpful tips, success stories, and essential resources for pet adoption and care. Let’s make your pet’s journey a happy one!
      </p>

      <div className="blog-posts">
        <div className="blog-post">
          <h2 className="post-title">🐱 10 Essential Tips for Caring for Your New Cat</h2>
          <p className="post-content">
            Bringing home a cat requires patience and care. In this blog, we’ll share 10 essential tips to make your new feline friend feel at home:
          </p>
          <ul className="tips-list">
            <li>
              <strong>1. Create a Safe Space:</strong> Set up a quiet, comfortable space for your cat with a bed, food, water, and a litter box.
            </li>
            <li>
              <strong>2. Gradual Introduction:</strong> Slowly introduce your cat to other pets in your home.
            </li>
            <li>
              <strong>3. Provide Scratching Posts:</strong> Give your cat a scratching post to maintain healthy claws.
            </li>
            <li>
              <strong>4. Litter Box Training:</strong> Ensure the litter box is clean and placed in a quiet location.
            </li>
            <li>
              <strong>5. Regular Vet Visits:</strong> Keep your cat healthy with regular veterinary check-ups.
            </li>
            <li>
              <strong>6. Hydration:</strong> Cats can be picky drinkers, so provide a water fountain to encourage drinking.
            </li>
            <li>
              <strong>7. Playtime and Stimulation:</strong> Keep your cat active with toys and puzzles.
            </li>
            <li>
              <strong>8. Cat-Proof Your Home:</strong> Remove harmful substances and small objects that could be a choking hazard.
            </li>
            <li>
              <strong>9. Respect Their Boundaries:</strong> Cats are independent and will let you know when they want attention.
            </li>
            <li>
              <strong>10. Be Patient:</strong> Give your cat time to adjust to their new environment.
            </li>
          </ul>
          <p className="closing-text">
            Every cat is unique, so take the time to learn what makes them happy and comfortable.
          </p>
          <p className="resource-link">
            For more information on caring for cats, visit <a href="https://en.wikipedia.org/wiki/Cat" target="_blank" rel="noopener noreferrer">Wikipedia</a>.
          </p>
        </div>
      </div>
    </div>
  );
}

export default BlogPage;
