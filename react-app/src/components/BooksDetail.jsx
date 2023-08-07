
import '../BooksDetail.css'; // Import your custom CSS for styling
import Card from 'react-bootstrap/esm/Card';

const BooksDetail = (props) => {
  // Assuming props.info.bondMaturityDate contains the date string "2021-08-04T23:00:00.000+00:00"
  const bookMaturityDate = new Date(props.info.bookMaturityDate);
  const formattedDate = bookMaturityDate.toISOString().split('T')[0];

  return (
    <div>
      <Card className="book-card">
        <Card.Body>
          <Card.Title><strong>ISIN:</strong> {props.info.isin}</Card.Title>
          <Card.Text>
            <strong>Issuer Name:</strong> {props.info.issuerName}<br />
            <strong>Bond Currency:</strong> {props.info.bookCurrency} <br />
            <strong>CUSIP:</strong> {props.info.cusip}<br />
            <strong>Bond Maturity Date:</strong> {formattedDate}<br />
            <strong>Status:</strong> {props.info.status}<br />
            <strong>Type:</strong> {props.info.type}<br />
            <strong>Face Value:</strong> {props.info.faceValue}<br />
            <strong>Client Id:</strong> {props.info.clientId}<br />
          </Card.Text>
        </Card.Body>
      </Card>

    </div>
  );
  
};

export default BooksDetail;

