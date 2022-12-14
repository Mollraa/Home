<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <<<<<<<<<<<<<<<<<<<< Breadcumb Area Start <<<<<<<<<<<<<<<<<<<< -->
	<div class="breadcumb_area">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<ol class="breadcrumb d-flex align-items-center">
						<li class="breadcrumb-item">Home</li>
						<li class="breadcrumb-item">${detail.productMajor }</li>
						<li class="breadcrumb-item active">${detail.productMinor }</li>
					</ol>
					<!-- btn -->
					<a href="javascript:history.back();" class="backToHome d-block"><i class="fa fa-angle-double-left"></i>Back to Category</a>
				</div>
			</div>
		</div>
	</div>
	<!-- <<<<<<<<<<<<<<<<<<<< Breadcumb Area End <<<<<<<<<<<<<<<<<<<< -->

	<!-- <<<<<<<<<<<<<<<<<<<< Single Product Details Area Start >>>>>>>>>>>>>>>>>>>>>>>>> -->
	<section class="single_product_details_area section_padding_0_100">
		<div class="container">
			<div class="row">

				<div class="col-12 col-md-6">
					<div class="single_product_thumb">
						<div id="product_details_slider" class="carousel slide"
							data-ride="carousel">

							<ol class="carousel-indicators">
								<li class="active" data-target="#product_details_slider"
									data-slide-to="0"
									style="background-image: url(img/product-img/product-9.jpg);">
								</li>
								<li data-target="#product_details_slider" data-slide-to="1"
									style="background-image: url(img/product-img/product-2.jpg);">
								</li>
								<li data-target="#product_details_slider" data-slide-to="2"
									style="background-image: url(img/product-img/product-3.jpg);">
								</li>
								<li data-target="#product_details_slider" data-slide-to="3"
									style="background-image: url(img/product-img/product-4.jpg);">
								</li>
							</ol>

							<div class="carousel-inner">
								<div class="carousel-item active">
									<a class="gallery_img" href="img/product-img/product-9.jpg">
										<img class="d-block w-100" src="img/product-img/product-9.jpg"
										alt="First slide">
									</a>
								</div>
								<div class="carousel-item">
									<a class="gallery_img" href="img/product-img/product-2.jpg">
										<img class="d-block w-100" src="img/product-img/product-2.jpg"
										alt="Second slide">
									</a>
								</div>
								<div class="carousel-item">
									<a class="gallery_img" href="img/product-img/product-3.jpg">
										<img class="d-block w-100" src="img/product-img/product-3.jpg"
										alt="Third slide">
									</a>
								</div>
								<div class="carousel-item">
									<a class="gallery_img" href="img/product-img/product-4.jpg">
										<img class="d-block w-100" src="img/product-img/product-4.jpg"
										alt="Fourth slide">
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-12 col-md-6">
					<div class="single_product_desc">

						<h4 class="title">
							<a href="#">${detail.productName }</a>
						</h4>

						<h4 class="price">???${detail.productPrice }</h4>

						<p class="available">
							Available: <span class="text-muted">In Stock</span>
						</p>

						<div class="widget size mb-50">
							<h6 class="widget-title">Size</h6>
							<div class="widget-desc">
								<ul>
									<li><a href="#">S</a></li>
									<li><a href="#">M</a></li>
									<li><a href="#">L</a></li>
								</ul>
							</div>
						</div>

						<!-- Add to Cart Form -->
						<form class="cart clearfix mb-50 d-flex" method="post">
							<div class="quantity">
								<span class="qty-plus"
									onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;">
									<i class="fa fa-plus" aria-hidden="true"></i>
								</span> <input type="number" class="qty-text" id="qty" step="1" min="1"
									max="12" name="quantity" value="1"> <span
									class="qty-minus"
									onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;">
									<i class="fa fa-minus" aria-hidden="true"></i>
								</span>
							</div>
							<button type="submit" name="addtocart" value="5"
								class="btn cart-submit d-block">Add to cart</button>
						</form>

						<div id="accordion" role="tablist">
							<div class="card">
								<div class="card-header" role="tab" id="headingOne">
									<h6 class="mb-0">
										<a data-toggle="collapse" href="#collapseOne"
											aria-expanded="true" aria-controls="collapseOne">?????? ?????? ??????</a>
									</h6>
								</div>

								<div id="collapseOne" class="collapse show" role="tabpanel"
									aria-labelledby="headingOne" data-parent="#accordion">
									<div class="card-body">
										<p>${detail.productExplain }</p>
									</div>
								</div>
							</div>
							<div class="card">
								<div class="card-header" role="tab" id="headingTwo">
									<h6 class="mb-0">
										<a class="collapsed" data-toggle="collapse"
											href="#collapseTwo" aria-expanded="false"
											aria-controls="collapseTwo">?????? ??????</a>
									</h6>
								</div>
								<div id="collapseTwo" class="collapse" role="tabpanel"
									aria-labelledby="headingTwo" data-parent="#accordion">
									<div class="card-body">
										<p>???????????? ????????? ????????? ?????? ????????? ?????????????????? ????????? ?????? 3-5??? ?????? ???????????????.
											???, ???????????? ????????? ????????? ??? ????????????.<br>
											??????, ??????, ?????? ?????? ??? ???????????? ???????????? ????????? 1-2??? ?????? ?????? ????????? ??? ?????? ??? ?????? ??????????????????.<br> 
											????????? ??? ?????? ??????????????? ?????? ?????? ?????? ?????? ?????? ???????????? ???????????????.<br> 
											???????????? ?????? ??? ??? ????????? ?????? ????????? ????????? ??? ????????????.<br></p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- <<<<<<<<<<<<<<<<<<<< Single Product Details Area End >>>>>>>>>>>>>>>>>>>>>>>>> -->

</body>
</html>