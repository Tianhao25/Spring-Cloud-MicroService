package demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(path = "paymentOrders")
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findTopBySenderUserName(@Param("userName") String userName);

    // update payment.paymentStatus
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Payment p set p.paymentStatus = ?1 where p.paymentId = ?2")
    void updatePaymentStatusById(String paymentStatus, Long paymentId);

    // http://localhost:9001/paymentOrders/1
    @RestResource(path = "paymentId")
    Payment findByPaymentId(@Param("paymentId") Long paymentId);
}
