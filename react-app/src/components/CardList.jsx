import React from 'react';

const cardData = [
  {
    title: 'Card 1',
    description: 'This is the first card.',
  },
  {
    title: 'Card 2',
    description: 'This is the second card.',
  },
  // Add more card objects as needed
];

const Card = ({ title, description }) => {
  return (
    <div className="card">
      <h3>{title}</h3>
      <p>{description}</p>
    </div>
  );
};

const CardList = () => {
  return (
    <div className="card-list">
      {cardData.map((card, index) => (
        <Card key={index} title={card.title} description={card.description} />
      ))}
    </div>
  );
};

export default CardList;