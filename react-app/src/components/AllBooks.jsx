import React, { useState, useEffect } from 'react';
import BooksDetail from './BooksDetail';
import Row from 'react-bootstrap/Row';
import { getAllBooks } from '../services/book-service';

const AllBooks = () => {
  const [books, setBooks] = useState([]);
  const [filterType, setFilterType] = useState(''); 
  const [filterCurrency, setFilterCurrency] = useState('');
  const [filterClientId, setFilterClientId] = useState(''); 
  const [showFilters, setShowFilters] = useState(false);

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

  // Filter the bonds based on the selected criteria
  const filteredBooks = books.filter(book => {
    // Filter by bond type
    if (filterType && book.type !== filterType) {
      return false;
    }
    // Filter by currency
    if (filterCurrency && book.bookCurrency !== filterCurrency) {
      return false;
    }

    if (filterClientId && book.clientId.toString() !== filterClientId) {
      return false;
    }
    // Add more filtering conditions here for other criteria if needed
    return true;
  });

   const toggleFilters = () => {
     setShowFilters(!showFilters);
   };


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
            <h1>All Bonds</h1>
          </div>
          <div>
          <br />
          </div>
               <div
                 className="bond-card"
                 style={{ backgroundColor: 'white', padding: '15px', cursor: 'pointer', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}
                 onClick={toggleFilters}
               >
                 <h5>Filter Options</h5>
                 <div
                   className="arrow-icon"
                   style={{ width: 0, height: 0, borderLeft: '5px solid transparent', borderRight: '5px solid transparent', borderTop: '8px solid white' }}
                 ></div>
               </div>

               {showFilters && (
                 <div
                   className="filter-options"
                   style={{ display: 'flex', backgroundColor: '#f9f9f9', padding: '10px', border: '1px solid #ccc', borderRadius: '4px' }}
                 >
                   <div className="filter-container">
                     <label className="filter-label">Filter by Type:</label>
                     <select value={filterType} onChange={(e) => setFilterType(e.target.value)}>
                       <option value="">All</option>
                       <option value="CORP">CORP</option>
                       <option value="GOVN">GOVN</option>
                       <option value="SOVN">SOVN</option>
                     </select>
                   </div>

                   <div className="filter-container">
                     <label className="filter-label">Filter by Currency:</label>
                     <select value={filterCurrency} onChange={(e) => setFilterCurrency(e.target.value)}>
                       <option value="">All</option>
                       <option value="USD">USD</option>
                       <option value="GBP">GBP</option>
                     </select>
                   </div>

                   <div className="filter-container">
                     <label className="filter-label">Filter by Client Id:</label>
                     <select value={filterClientId} onChange={(e) => setFilterClientId(e.target.value)}>
                       <option value="">All</option>
                       <option value="1000">1000</option>
                       <option value="1001">1001</option>
                       <option value="1002">1002</option>
                       <option value="1003">1003</option>
                       <option value="1004">1004</option>
                     </select>
                   </div>
                 </div>
               )}



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