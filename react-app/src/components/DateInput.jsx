import React, { useState } from 'react';


const DateInput = ({ onDateSubmit }) => {
  const [selectedDate, setSelectedDate] = useState('');

  const handleSubmit = () => {
    onDateSubmit(selectedDate);
  };

  return (
    <div>
      <input
        type="date"
        value={selectedDate}
        onChange={(e) => setSelectedDate(e.target.value)}
      />
      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
};

export default DateInput;