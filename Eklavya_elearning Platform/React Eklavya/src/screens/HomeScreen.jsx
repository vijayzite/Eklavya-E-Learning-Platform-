import React from "react";
import { Container } from "reactstrap";
import Carousel from "../components/carousel/Carousel";
import Welcome from "../components/typewriter/Welcome";
import "./common.css";
import Footer from "../components/footer/Footer";

const HomeScreen = () => {
  return (
    <div className="homeScreen">
      <Carousel className="carousel" />
      {/* <Welcome className="wel" /> */}
      <Footer/>
    </div>
  );
};

export default HomeScreen;
