
import React from 'react';
import { Link } from 'react-router-dom'; // Import Link from react-router-dom

const Footer = () => {
  return (
    <div id="contact">
      <footer className="bg-dark text-light py-4">
        <div className="container">
          <div className="row">
            <div className="col-md-3">
              <h5>Eklavya Business</h5>
              {/* Use Link component instead of <a> to navigate to a new page */}
              <ul className="list-unstyled">
                {/* <li><Link to="/teach">Teach on Eklavya</Link></li> */}
                <li>Get the app</li>
                <li>About us</li>
                <li>Contact us</li>
                <li>Careers</li>
              </ul>
            </div>
            <div className="col-md-3">
              <h5>Resources</h5>
              <ul className="list-unstyled">
                <li>Blog</li>
                <li>Help and Support</li>
                <li>Affiliate</li>
                <li>Investors</li>
              </ul>
            </div>
            <div className="col-md-3">
              <h5>Legal</h5>
              <ul className="list-unstyled">
                <li>Terms</li>
                <li>Privacy policy</li>
                <li>Sitemap</li>
                <li>Accessibility statement</li>
              </ul>
            </div>
            <div className="col-md-3">
              <p>© 2024 Eklavya, Inc.</p>
            </div>
          </div>
        </div>
      </footer>
    </div>
  );
};

export default Footer;

