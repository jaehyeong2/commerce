package ljh.commerce.commerce.service;

import ljh.commerce.commerce.domain.image.ProductImageRepository;
import ljh.commerce.commerce.dto.ProductReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductImageService {

    private final ProductImageRepository productImageRepository;

    public void upload(ProductReqDto productReqDto){

    }
}
