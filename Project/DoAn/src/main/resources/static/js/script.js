(function($) {

  "use strict";

  /* ===== PRODUCT QTY ===== */
  var initProductQty = function () {

    if (!$('.product-qty').length) return;

    $('.product-qty').each(function () {

      var $el_product = $(this);

      $el_product.find('.quantity-right-plus').on('click', function (e) {
        e.preventDefault();
        var quantity = parseInt($el_product.find('#quantity').val()) || 0;
        $el_product.find('#quantity').val(quantity + 1);
      });

      $el_product.find('.quantity-left-minus').on('click', function (e) {
        e.preventDefault();
        var quantity = parseInt($el_product.find('#quantity').val()) || 0;
        if (quantity > 0) {
          $el_product.find('#quantity').val(quantity - 1);
        }
      });

    });

  };

  $(document).ready(function () {

    /* ===== VIDEO MODAL ===== */
    if ($('.play-btn').length) {
      var videoSrc = '';

      $('.play-btn').on('click', function () {
        videoSrc = $(this).data('src');
      });

      $('#myModal').on('shown.bs.modal', function () {
        $('#video').attr(
          'src',
          videoSrc + '?autoplay=1&modestbranding=1&showinfo=0'
        );
      });

      $('#myModal').on('hide.bs.modal', function () {
        $('#video').attr('src', '');
      });
    }
    if ($('.category-swiper').length) {
        new Swiper('.category-swiper', {
            speed: 800,
            spaceBetween: 20, // Khoảng cách giữa các slide
            loop: true, // Nếu cần lặp vô hạn
            navigation: {
                nextEl: '.category-next', // Tên nút next trong HTML
                prevEl: '.category-prev', // Tên nút prev trong HTML
            },
            // Cấu hình responsive: Cần hiển thị bao nhiêu cột trên mỗi kích thước màn hình
            breakpoints: {
                0: { slidesPerView: 1 }, // Màn hình nhỏ (điện thoại)
                768: { slidesPerView: 3 }, // Màn hình tablet
                1200: { slidesPerView: 4 }, // Màn hình desktop (thường dùng 3-5 cột)
            },
        });
    }

    /* ===== MAIN SLIDER (HOME) ===== */
    if ($('.main-swiper').length) {
      new Swiper('.main-swiper', {
        speed: 800,
        loop: true,
        pagination: {
          el: '.main-slider-pagination',
          clickable: true,
        },
      });
    }

    /* ===== PRODUCT SLIDER ===== */
    /* ===== PRODUCT SLIDER (Đã sửa) ===== */
    if ($('.product-swiper').length) {
        new Swiper('.product-swiper', {
            speed: 800,
            loop: true,
            spaceBetween: 20,
            navigation: {
              // SỬA: Đổi tên Navigation cho khớp với HTML
              nextEl: '.product-next',
              prevEl: '.product-prev',
            },
            breakpoints: {
              0: { slidesPerView: 1 },
              480: { slidesPerView: 2 },
              900: { slidesPerView: 3 },
              1200: { slidesPerView: 4 }, // Đã sửa từ 5 thành 4
            },
        });
    }

    /* ===== TESTIMONIAL ===== */
    if ($('.testimonial-swiper').length) {
      new Swiper('.testimonial-swiper', {
        speed: 800,
        navigation: {
          nextEl: '.testimonial-arrow-next',
          prevEl: '.testimonial-arrow-prev',
        },
      });
    }

    /* ===== PRODUCT SLIDER 2 ===== */
    if ($('.product-swiper2').length) {
      new Swiper('.product-swiper2', {
        speed: 800,
        spaceBetween: 20,
        navigation: {
          nextEl: '.product-carousel-next2',
          prevEl: '.product-carousel-prev2',
        },
        breakpoints: {
          0: { slidesPerView: 1 },
          480: { slidesPerView: 2 },
          900: { slidesPerView: 3 },
          1200: { slidesPerView: 5 },
        },
      });
    }

    /* ===== PRODUCT DETAIL ===== */
    if ($('.thumb-swiper').length && $('.large-swiper').length) {

      var thumbSlider = new Swiper('.thumb-swiper', {
        slidesPerView: 4,
        spaceBetween: 10,
      });

      new Swiper('.large-swiper', {
        spaceBetween: 10,
        effect: 'fade',
        thumbs: {
          swiper: thumbSlider,
        },
      });
    }

    initProductQty();

  });

})(jQuery);
