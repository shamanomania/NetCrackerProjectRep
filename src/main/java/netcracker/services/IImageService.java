package netcracker.services;

import netcracker.domain.entities.Images;
import netcracker.domain.entities.Test;

/**
 * Created by Sid775 on 11.02.2017.
 */
public interface IImageService {
    public Images findById(Long id);
    public void save(Images images);
    public Images findTestImg(Test test);
    public Images findTop();
}
