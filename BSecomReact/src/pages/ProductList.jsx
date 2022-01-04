import styled from "styled-components";
import Products from "../components/Product";
import CategoryService from "../service/CategoryService";
import React, { useState, useEffect } from "react";
import { mobile } from "../responsive";

const Container = styled.div``;

const Title = styled.h1`
  margin: 20px;
`;

const FilterContainer = styled.div`
  display: flex;
  justify-content: space-between;
`;

const Filter = styled.div`
  margin: 20px;
  ${mobile({ width: "0px 20px", display: "flex", flexDirection: "column" })}
`;

const FilterText = styled.span`
  font-size: 20px;
  font-weight: 600;
  margin-right: 20px;
  ${mobile({ marginRight: "0px" })}
`;

const Select = styled.select`
  padding: 10px;
  margin-right: 20px;
  ${mobile({ margin: "10px 0px" })}
`;
const Option = styled.option``;

const ProductList = () => {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    let categoryService = new CategoryService();
    categoryService.getAll().then((result) => setCategories(result.data.data));
  }, []);

  return (
    <Container id = "products">
      <Title>Books</Title>
      <FilterContainer>
        <Filter>
          <FilterText>Filter Products:</FilterText>
          <Select>
            <Option disabled selected>
              Type of Book
            </Option>
            {categories.map((category) => (
              <Option>{category.categoryName}</Option>
            ))}
          </Select>
        </Filter>
        <Filter>
          <FilterText>Sort Products by Page:</FilterText>
          <Select>
            <Option selected>Newest</Option>
            <Option>Page (asc)</Option>
            <Option>Page (desc)</Option>
          </Select>
        </Filter>
      </FilterContainer>
      <Products/>
    </Container>
  );
};

export default ProductList;
