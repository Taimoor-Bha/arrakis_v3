import React, { useState, useEffect } from 'react';
import BooksDetail from './BooksDetail';
import Row from 'react-bootstrap/Row';
import { getAllBooks } from '../services/book-service';

const AllBooks = () => {
  const [books, setBooks] = useState([]);
  const [filterClientId, setFilterClientId] = useState('');
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  // Add more state variables for other filter criteria if needed

  useEffect(() => {
    getBooksFromAPI();
  }, []);

  const getBooksFromAPI = () => {
    getAllBooks()
      .then(res => {
        setBooks(res.data);
      })
      .catch(err => {
        setBooks([]);
        console.log(err);
      });
  };

  // Filter the books based on the selected criteria
  const filteredBooks = books.filter(book => {
    // Existing filters for clientId and maturityDate
    if (filterClientId && book.clientId.toString() !== filterClientId) {
      return false;
    }
  
    // New filter for date range
    if (startDate && endDate) {
      const bookDate = new Date(book.bookMaturityDate); // Replace 'dateValue' with the actual property holding the date value
      const start = new Date(startDate);
      const end = new Date(endDate);
  
      if (bookDate < start || bookDate > end) {
        return false;
      }
    }
  
    return true;
  });
  



  const HeaderFormat = {
    backgroundColor: 'rgba(172, 98, 33, 0.949)',
    color: 'white',
    padding: '15px',
    textAlign: 'left',
  };

  //
  return (
    <div>
      {/* Top band */}
      <div style={HeaderFormat}>
        <h1>FIC Bond Tracker</h1>
      </div>
      <div>
        <br />
      </div>


      <div
        className="filter-options"
        style={{ display: 'flex', backgroundColor: '#f9f9f9', padding: '10px', border: '1px solid #ccc', borderRadius: '4px' }}
      >

        <div className="filter-container">
          <label className="filter-label">Filter by Client:</label>
          <select value={filterClientId} onChange={(e) => setFilterClientId(e.target.value)}>
            <option value="">All Clients</option>
            <option value="1000">Client 1000</option>
            <option value="1001">Client 1001</option>
            <option value="1002">Client 1002</option>
            <option value="1003">Client 1003</option>
            <option value="1004">Client 1004</option>
          </select>
        </div>

        <div className="filter-container">
          <label className="filter-label">Start Date:</label>
          <input
            type="date"
            value={startDate}
            onChange={(e) => setStartDate(e.target.value)}
          />
        </div>

        <div className="filter-container">
          <label className="filter-label">End Date:</label>
          <input
            type="date"
            value={endDate}
            onChange={(e) => setEndDate(e.target.value)}
          />
        </div>


      </div>


      <Row>
        {filteredBooks.map(book => (
          <div className='container' key={book.isin}>
            <BooksDetail info={book} />
          </div>
        ))}
      </Row>
    </div>
  );
};

export default AllBooks;