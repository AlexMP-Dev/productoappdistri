package com.productoappdistri2.productoappdistri2.services;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import com.productoappdistri2.productoappdistri2.dto.CardPaymentDTO;
import com.productoappdistri2.productoappdistri2.dto.PaymentResponseDTO;
import com.productoappdistri2.productoappdistri2.exception.MercadoPagoException;

import org.springframework.stereotype.Service;

@Service
public class CardPaymentService {
  
  private String mercadoPagoAccessToken = "";

  public PaymentResponseDTO processPayment(CardPaymentDTO cardPaymentDTO) {
    try {
      MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);

      PaymentClient paymentClient = new PaymentClient();

      PaymentCreateRequest paymentCreateRequest =
          PaymentCreateRequest.builder()
              .transactionAmount(cardPaymentDTO.getTransactionAmount())
              .token(cardPaymentDTO.getToken())
              .description(cardPaymentDTO.getProductDescription())
              .installments(cardPaymentDTO.getInstallments())
              .paymentMethodId(cardPaymentDTO.getPaymentMethodId())
              .payer(
                  PaymentPayerRequest.builder()
                      .email(cardPaymentDTO.getPayer().getEmail())
                      .identification(
                          IdentificationRequest.builder()
                              .type(cardPaymentDTO.getPayer().getIdentification().getType())
                              .number(cardPaymentDTO.getPayer().getIdentification().getNumber())
                              .build())
                      .build())
              .build();

      Payment createdPayment = paymentClient.create(paymentCreateRequest);

      return new PaymentResponseDTO(
          createdPayment.getId(),
          String.valueOf(createdPayment.getStatus()),
          createdPayment.getStatusDetail());
    } catch (MPApiException apiException) {
      System.out.println(apiException.getApiResponse().getContent());
      throw new MercadoPagoException(apiException.getApiResponse().getContent());
    } catch (MPException exception) {
      System.out.println(exception.getMessage());
      throw new MercadoPagoException(exception.getMessage());
    }
  }
}