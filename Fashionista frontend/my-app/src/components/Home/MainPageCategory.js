import React, { useEffect, useState } from "react";
import subcategoryService from "../../services/subcategory.service";
import womenSaree from "../../images/SubCategory/womenSaree.jpg";
import womenJean from '../../images/SubCategory/womenJean.jpg';
import womenShirt from "../../images/SubCategory/womenShirt.jpg";
import womenSuit from "../../images/SubCategory/womenSuit.jpg";
import womenTop from "../../images/SubCategory/womenTop.jpg";
import "./MainPageCategory.css";

const MainPageCategory = () => {
  const [subCategory, setSubCategory] = useState([]);

  const init = () => {
    subcategoryService
      .getAll()
      .then((response) => {
        console.log("Prinit subcategory : ", response.data);
        setSubCategory(response.data);
        console.warn(response.data);
      })
      .catch((error) => {
        console.log("Something went wrong in subcategory", error);
      });
  };

  useEffect(() => {
    init();
  }, []);

  const subCatList = subCategory.map((subCat, index) => {
    return (
      <a href={`#${subCat.subCatId}`} key={index}>
        {subCat.subCategoryName}
      </a>
    );
  });

  return (
    <div className="center">
      <table>
        <tr>
          <td>
            <div className="image-container">
              <img
                src={womenSaree}
                alt="example"
                style={{ borderRadius: 50 }}
                className="image-with-border"
              />
            </div>
          </td>
          <td>
            <div className="image-container">
              <img
                src={womenJean}
                alt="example"
                style={{ borderRadius: 50 }}
                className="image-with-border"
              />
            </div>
          </td>
          <td>
            <div className="image-container">
              <img
                src={womenShirt}
                alt="example"
                style={{ borderRadius: 50 }}
                className="image-with-border"
              />
            </div>
          </td>
          <td>
            <div className="image-container">
              <img
                src={womenSuit}
                alt="example"
                style={{ borderRadius: 50 }}
                className="image-with-border"
              />
            </div>
          </td>
          <td>
            <div className="image-container">
              <img
                src={womenTop}
                alt="example"
                style={{ borderRadius: 50 }}
                className="image-with-border"
              />
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div className="image-container">
              <img
                src={womenSaree}
                alt="example"
                style={{ borderRadius: 50 }}
                className="image-with-border"
              />
            </div>
          </td>
          <td>
            <div className="image-container">
              <img
                src={womenSaree}
                alt="example"
                style={{ borderRadius: 50 }}
                className="image-with-border"
              />
            </div>
          </td>
          <td>
            <div className="image-container">
              <img
                src={womenSaree}
                alt="example"
                style={{ borderRadius: 50 }}
                className="image-with-border"
              />
            </div>
          </td>
          <td>
            <div className="image-container">
              <img
                src={womenSaree}
                alt="example"
                style={{ borderRadius: 50 }}
                className="image-with-border"
              />
            </div>
          </td>
          <td>
            <div className="image-container">
              <img
                src={womenSaree}
                alt="example"
                style={{ borderRadius: 50 }}
                className="image-with-border"
              />
            </div>
          </td>
        </tr>
      </table>
    </div>
  );
};
export default MainPageCategory;
