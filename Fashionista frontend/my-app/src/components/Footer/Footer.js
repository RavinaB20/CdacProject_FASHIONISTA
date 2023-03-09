import React from "react";
import "./Footer.css";
import { Link } from 'react-router-dom';
import {Whoarewe} from './Whoarewe.js';
import ContactUs from './ContactUs';

const Footer = () => {
  return (
    <div className="footer-container">
      <table>
        <tr>
          <th>
            FASHIONISTA
          </th>
          <th>
            TOP CATEGORIES
          </th>
          <th>
            CUSTOMER POLICIES
          </th>
        </tr>
        <tr>
          <td>
            <Link to="/Whoarewe" style={{color:'palevioletred'}}>Who are we?</Link>
          </td>
          <td>
            Shirts
          </td>
          <td>
          <Link to="/ContactUs" style={{color:'palevioletred'}}>Contact Us</Link>
          </td>
        </tr>
        <tr>
          <td>
            Careers
          </td>
          <td>
            Jeans
          </td>
          <td>
          <Link to="/Faq" style={{color:'palevioletred'}}>FAQ</Link>
          </td>
        </tr>
        <tr>
          <td>
          </td>
          <td>Sarees</td>
          <td></td>
        </tr>
        <tr>
          <td>
          </td>
          <td>Suits</td>
          <td></td>
        </tr>
        <tr>
          <td>
          </td>
          <td>Tops</td>
          <td></td>
        </tr>
        <tr>
          <td>
          </td>
          <td>T-shirts</td>
          <td></td>
        </tr>
      </table>
    </div>
  );
};
export default Footer;