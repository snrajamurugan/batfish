package org.batfish.representation.cisco;

import java.util.LinkedList;
import java.util.List;
import org.batfish.common.util.DefinedStructure;
import org.batfish.datamodel.DiffieHellmanGroup;

public class IpsecProfile extends DefinedStructure<String> {

  private static final long serialVersionUID = 1L;

  private String _isakmpProfile;

  private DiffieHellmanGroup _pfsGroup;

  private List<String> _transformSets;

  public IpsecProfile(String name, int definitionLine) {
    super(name, definitionLine);
    _transformSets = new LinkedList<>();
  }

  public String getIsakmpProfile() {
    return _isakmpProfile;
  }

  public DiffieHellmanGroup getPfsGroup() {
    return _pfsGroup;
  }

  public List<String> getTransformSets() {
    return _transformSets;
  }

  public void setIsakmpProfile(String isakmpProfile) {
    _isakmpProfile = isakmpProfile;
  }

  public void setPfsGroup(DiffieHellmanGroup pfsGroup) {
    _pfsGroup = pfsGroup;
  }

  public void setTransformSet(List<String> transformSets) {
    _transformSets = transformSets;
  }
}
