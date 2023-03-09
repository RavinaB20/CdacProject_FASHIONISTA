import React from 'react'
import Footer from './Footer/Footer.js';
import Banner from './Home/Banner.js';
import CustomNavbar from './Home/CustomNavbar';
import MainPageCategory from './Home/MainPageCategory';

export default function MainPage() {
  return (
    <div>
      <CustomNavbar/>
      <Banner/>
      <MainPageCategory/>
      <Footer/>
    </div>
  )
}
