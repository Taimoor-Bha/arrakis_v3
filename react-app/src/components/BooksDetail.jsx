
import '../BooksDetail.css'; // Import your custom CSS for styling

const BooksDetail = (props) => {
  // Assuming props.info.bondMaturityDate contains the date string "2021-08-04T23:00:00.000+00:00"
  const bookMaturityDate = new Date(props.info.bookMaturityDate);
  const formattedDate = bookMaturityDate.toISOString().split('T')[0];

  return (
    <div>
      <table className="book-table">
        <tbody>
          <tr>
            <td><strong>ISIN:</strong></td>
            <td>{props.info.isin}</td>
          </tr>
          <tr>
            <td><strong>Issuer Name:</strong></td>
            <td>{props.info.issuerName}</td>
          </tr>
          <tr>
            <td><strong>Book Currency:</strong></td>
            <td>{props.info.bookCurrency}</td>
          </tr>
          <tr>
            <td><strong>CUSIP:</strong></td>
            <td>{props.info.cusip}</td>
          </tr>
          <tr>
            <td><strong>Book Maturity Date:</strong></td>
            <td>{formattedDate}</td>
          </tr>
          <tr>
            <td><strong>Status:</strong></td>
            <td>{props.info.status}</td>
          </tr>
          <tr>
            <td><strong>Type:</strong></td>
            <td>{props.info.type}</td>
          </tr>
          <tr>
            <td><strong>Face Value:</strong></td>
            <td>{props.info.faceValue}</td>
          </tr>
          <tr>
            <td><strong>Client Id:</strong></td>
            <td>{props.info.clientId}</td>
          </tr>
        </tbody>
      </table>
    </div>
  );

};

export default BooksDetail;

