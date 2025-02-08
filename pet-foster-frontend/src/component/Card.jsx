import React from 'react';

const Card = ({ title, description, imageUrl }) => {
  return (
    <div style={styles.card}>
      {imageUrl && <img src={imageUrl} alt={title} style={styles.image} />}
      <h2 style={styles.title}>{title}</h2>
      <p style={styles.description}>{description}</p>
    </div>
  );
};


const styles = {
    card: {
      border: '1px solid #ddd',
      borderRadius: '8px',
      padding: '20px',
      width: '300px',
      boxShadow: '0 4px 6px rgba(0, 0, 0, 0.1)',
      backgroundColor: '#fff',
      textAlign: 'center',
    },
    image: {
      width: '100%',
      height: 'auto',
      borderRadius: '8px',
    },
    title: {
      fontSize: '1.5em',
      color: '#333',
      marginTop: '10px',
    },
    description: {
      color: '#555',
      marginTop: '10px',
    },
  };
  
  export default Card;