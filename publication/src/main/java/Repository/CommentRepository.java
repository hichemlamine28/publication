/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import com.relation.publication.Model.Comment;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Hichem
 */
public interface CommentRepository extends CrudRepository<Entity, Id> {
List<Comment> findByPostId(Long postId);
Comment findByIdAndPostId(Long id, Long postId);      
}
