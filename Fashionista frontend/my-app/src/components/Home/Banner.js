import React from "react";
import Carousel from "react-bootstrap/Carousel";
import manimg from "../../images/Banner/Man1.jpg";
import womenGroupImg from "../../images/Banner/Woman2.jpg";
import manGroupImg from "../../images/Banner/GroupImage.jpg";
import womenImg from "../../images/Banner/woman1.jpg";

function Banner() {
  return (
    <div>
      <Carousel>
        <Carousel.Item interval={2000}>
          <img className="d-block w-100" height={430} src={womenGroupImg} alt="First slide" />
          <Carousel.Caption>
            <h3>First slide label</h3>
            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item interval={2000}>
          <img className="d-block w-100" height={430} src={manimg} alt="Second slide" />
          <Carousel.Caption>
            <h3>Second slide label</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img className="d-block w-100" height={430} src={womenImg} alt="Third slide" />
          <Carousel.Caption>
            <h3>Third slide label</h3>
            <p>
              Praesent commodo cursus magna, vel scelerisque nisl consectetur.
            </p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img className="d-block w-100" height={430} src={manGroupImg} alt="Third slide" />
          <Carousel.Caption>
            <h3>Third slide label</h3>
            <p>
              Praesent commodo cursus magna, vel scelerisque nisl consectetur.
            </p>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel>
    </div>
  );
}

export default Banner;
