package ee.rada8.back_rada8.domain.advertisements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    @Query("select a from Advertisement a where a.user.id = ?1 and a.type.id = ?2 order by a.editedTimestamp")
    List<Advertisement> findByUserIdAndTypeId(Integer userId, Integer typeId);




    @Query("select a from Advertisement a where a.status = ?1 order by a.editedTimestamp DESC")
    List<Advertisement> findAllActiveAdvertisements(String status);






    @Query("select a from Advertisement a where a.city.id = ?1 and a.type.id = ?2 and a.status = ?3 order by a.editedTimestamp DESC")
    List<Advertisement> findActiveAdvertisements(Integer id, Integer id1, String status);



}