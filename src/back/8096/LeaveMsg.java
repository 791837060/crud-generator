import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int128;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 5.0.0.
 */
@SuppressWarnings("rawtypes")
public class LeaveMsg extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b50600436106101cf5760003560e01c80637116c60c11610104578063c2c4c5c1116100a2578063da020a1811610071578063da020a1814610497578063ee00ef3a146104aa578063eff7a612146104b5578063fc0c546a146104c857600080fd5b8063c2c4c5c1146103f6578063cbf9fe5f146103fe578063d07b705f14610446578063d1febfb91461045957600080fd5b8063900cf0cf116100de578063900cf0cf1461038b57806395d89b4114610394578063981b24d0146103b7578063adc63589146103ca57600080fd5b80637116c60c1461032f57806371197484146103425780637c74a1741461037857600080fd5b80633a46273e116101715780634ee2cd7e1161014b5780634ee2cd7e146102ec5780635b51c308146102ff57806365fc38731461030957806370a082311461031c57600080fd5b80633a46273e146102be5780633ccfd60b146102d15780634957677c146102d957600080fd5b80630a4345a8116101ad5780630a4345a81461024c57806318160ddd1461026157806328d09d4714610269578063313ce567146102a457600080fd5b8063010ae757146101d4578063047fc9aa1461020757806306fdde0314610210575b600080fd5b6101f46101e23660046121cf565b60066020526000908152604090205481565b6040519081526020015b60405180910390f35b6101f460015481565b61023f6040518060400160405280601081526020016f0acdee8ca5acae6c6e4deeecac8409eb60831b81525081565b6040516101fe919061220e565b61025f61025a366004612241565b610507565b005b6101f46105fb565b61027c610277366004612274565b61060b565b60408051600f95860b81529390940b60208401529282015260608101919091526080016101fe565b6102ac601281565b60405160ff90911681526020016101fe565b61025f6102cc366004612274565b610652565b61025f610728565b61025f6102e736600461229e565b610744565b6101f46102fa366004612274565b610762565b6101f46212750081565b61025f6103173660046122b7565b610a53565b6101f461032a3660046121cf565b610a6f565b6101f461033d36600461229e565b610a7b565b61036561035036600461229e565b600760205260009081526040902054600f0b81565b604051600f9190910b81526020016101fe565b6103656103863660046121cf565b610a86565b6101f460035481565b61023f604051806040016040528060048152602001630ecca9eb60e31b81525081565b6101f46103c536600461229e565b610ad3565b6101f46103d83660046121cf565b6001600160a01b031660009081526002602052604090206001015490565b61025f610c72565b61042c61040c3660046121cf565b60026020526000908152604090208054600190910154600f9190910b9082565b60408051600f9390930b83526020830191909152016101fe565b6101f4610454366004612274565b610cb0565b61027c61046736600461229e565b600460205260009081526040902080546001820154600290920154600f82810b93600160801b909304900b919084565b6101f46104a5366004612274565b610cc3565b6101f46301e1338081565b61025f6104c336600461229e565b610cff565b6104ef7f00000000000000000000000078a0a62fba6fb21a83fe8a3433d44c73a4017a6f81565b6040516001600160a01b0390911681526020016101fe565b61050f610d10565b604051633d1bb33160e21b81523360048201527f00000000000000000000000078a0a62fba6fb21a83fe8a3433d44c73a4017a6f6001600160a01b03169063f46eccc490602401602060405180830381865afa158015610573573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061059791906122d9565b6105e15760405162461bcd60e51b815260206004820152601660248201527529b2b73232b91034b9903737ba10309036b4b73a32b960511b60448201526064015b60405180910390fd5b6105ec838383610d69565b6105f66001600055565b505050565b600061060642610e82565b905090565b600560205281600052604060002081633b9aca00811061062a57600080fd5b6003020180546001820154600290920154600f82810b9550600160801b90920490910b925084565b61065a610d10565b6001600160a01b03821660009081526002602090815260409182902082518084019093528054600f0b835260010154908201528161069757600080fd5b60008160000151600f0b136106e75760405162461bcd60e51b8152602060048201526016602482015275139bc8195e1a5cdd1a5b99c81b1bd8dac8199bdd5b9960521b60448201526064016105d8565b4281602001511161070a5760405162461bcd60e51b81526004016105d8906122fb565b61071983836000846000610ee2565b506107246001600055565b5050565b610730610d10565b61073861105d565b6107426001600055565b565b61074c610d10565b610755816111ac565b61075f6001600055565b50565b60004382111561077157600080fd5b6001600160a01b038316600090815260066020526040812054815b6080811015610825578183101561082557600060026107ab8486612355565b6107b6906001612355565b6107c0919061237e565b6001600160a01b0388166000908152600560205260409020909150869082633b9aca0081106107f1576107f1612392565b60030201600201541161080657809350610814565b6108116001826123a8565b92505b5061081e816123bb565b905061078c565b506001600160a01b038516600090815260056020526040812083633b9aca00811061085257610852612392565b604080516080810182526003928302939093018054600f81810b8652600160801b909104900b60208501526001810154918401919091526002015460608301525490915060006108a28783611262565b600081815260046020908152604080832081516080810183528154600f81810b8352600160801b909104900b938101939093526001810154918301919091526002015460608201529192508084841015610981576000600481610906876001612355565b8152602080820192909252604090810160002081516080810183528154600f81810b8352600160801b909104900b9381019390935260018101549183019190915260020154606080830182905286015191925061096391906123a8565b92508360400151816040015161097991906123a8565b9150506109a5565b606083015161099090436123a8565b91508260400151426109a291906123a8565b90505b604083015182156109e2578284606001518c6109c191906123a8565b6109cb90846123d4565b6109d5919061237e565b6109df9082612355565b90505b60408701516109f190826123a8565b8760200151610a0091906123eb565b87518890610a0f90839061240b565b600f90810b90915288516000910b129050610a3f57505093516001600160801b03169650610a4d95505050505050565b600099505050505050505050505b92915050565b610a5b610d10565b610a6582826112e8565b6107246001600055565b6000610a4d82426113f7565b6000610a4d82610e82565b6001600160a01b0381166000908152600660209081526040808320546005909252822081633b9aca008110610abd57610abd612392565b6003020154600160801b9004600f0b9392505050565b600043821115610ae257600080fd5b6003546000610af18483611262565b600081815260046020908152604080832081516080810183528154600f81810b8352600160801b909104900b9381019390935260018101549183019190915260020154606082015291925083831015610c00576000600481610b54866001612355565b8152602080820192909252604090810160002081516080810183528154600f81810b8352600160801b909104900b9381019390935260018101549183019190915260020154606080830182905285015191925014610bfa5782606001518160600151610bc091906123a8565b83604001518260400151610bd491906123a8565b6060850151610be3908a6123a8565b610bed91906123d4565b610bf7919061237e565b91505b50610c4f565b43826060015114610c4f576060820151610c1a90436123a8565b6040830151610c2990426123a8565b6060840151610c3890896123a8565b610c4291906123d4565b610c4c919061237e565b90505b610c6882828460400151610c639190612355565b6114e6565b9695505050505050565b610742600060405180604001604052806000600f0b8152602001600081525060405180604001604052806000600f0b815260200160008152506115e7565b6000610cbc83836113f7565b9392505050565b6001600160a01b038216600090815260056020526040812082633b9aca008110610cef57610cef612392565b6003020160010154905092915050565b610d07610d10565b61075581611c4d565b600260005403610d625760405162461bcd60e51b815260206004820152601f60248201527f5265656e7472616e637947756172643a207265656e7472616e742063616c6c0060448201526064016105d8565b6002600055565b60008211610d7657600080fd5b6001600160a01b03831660009081526002602090815260409182902082518084019093528054600f0b8084526001909101549183019190915215610df85760405162461bcd60e51b815260206004820152601960248201527815da5d1a191c985dc81bdb19081d1bdad95b9cc8199a5c9cdd603a1b60448201526064016105d8565b600062093a80610e08818561237e565b610e1291906123d4565b9050610e216212750042612355565b811015610e405760405162461bcd60e51b81526004016105d890612438565b610e4e6301e1338042612355565b811115610e6d5760405162461bcd60e51b81526004016105d89061247c565b610e7b858583856001611db0565b5050505050565b600354600081815260046020908152604080832081516080810183528154600f81810b8352600160801b909104900b93810193909352600181015491830191909152600201546060820152909190610eda81856114e6565b949350505050565b6001548290610ef18682612355565b6001556040805180820190915260008082526020820152825160208085015190830152600f0b8152825187908490610f2a9083906124b3565b600f0b9052508515610f3e57602083018690525b6001600160a01b0388166000908152600260209081526040909120845181546001600160801b0319166001600160801b0390911617815590840151600190910155610f8a8882856115e7565b8615610fc557610fc56001600160a01b037f00000000000000000000000078a0a62fba6fb21a83fe8a3433d44c73a4017a6f1689308a611f20565b8260200151886001600160a01b03167fbe9cf0e939c614fad640a623a53ba0a807c8cb503c4c4c8dacabe27b86ff2dd5898742604051611007939291906124e0565b60405180910390a37f5e2aa66efd74cce82b21852e317e5490d9ecc9e6bb953ae24d90851258cc2f5c8261103b8982612355565b6040805192835260208301919091520160405180910390a15050505050505050565b336000818152600260208181526040808420815180830183528154600f81900b808352600180850180548589015286518088019097528987528688018a81529a9099529690955292516001600160801b03166001600160801b03199093169290921790559351909255546110d182826123a8565b60015560408051808201909152600080825260208201526110f590339085906115e7565b6111296001600160a01b037f00000000000000000000000078a0a62fba6fb21a83fe8a3433d44c73a4017a6f163384611f8b565b6040805183815242602082015233917ff279e6a1f5e320cca91135676d9cb6e44ca8a08c0b88342bcdb1144f6511b568910160405180910390a27f5e2aa66efd74cce82b21852e317e5490d9ecc9e6bb953ae24d90851258cc2f5c8161118f84826123a8565b6040805192835260208301919091520160405180910390a1505050565b3360009081526002602090815260409182902082518084019093528054600f0b83526001015490820152816111e057600080fd5b60008160000151600f0b136112305760405162461bcd60e51b8152602060048201526016602482015275139bc8195e1a5cdd1a5b99c81b1bd8dac8199bdd5b9960521b60448201526064016105d8565b428160200151116112535760405162461bcd60e51b81526004016105d8906122fb565b61072433836000846002610ee2565b60008082815b60808110156112de57818310156112de57600060026112878486612355565b611292906001612355565b61129c919061237e565b60008181526004602052604090206002015490915087106112bf578093506112cd565b6112ca6001826123a8565b92505b506112d7816123bb565b9050611268565b5090949350505050565b600082116112f557600080fd5b3360009081526002602090815260409182902082518084019093528054600f0b808452600190910154918301919091521561136e5760405162461bcd60e51b815260206004820152601960248201527815da5d1a191c985dc81bdb19081d1bdad95b9cc8199a5c9cdd603a1b60448201526064016105d8565b600062093a8061137e818561237e565b61138891906123d4565b90506113976212750042612355565b8110156113b65760405162461bcd60e51b81526004016105d890612438565b6113c46301e1338042612355565b8111156113e35760405162461bcd60e51b81526004016105d89061247c565b6113f1338583856001610ee2565b50505050565b6001600160a01b038216600090815260066020526040812054808203611421576000915050610a4d565b6001600160a01b038416600090815260056020526040812082633b9aca00811061144d5761144d612392565b60408051608081018252600392909202929092018054600f81810b8452600160801b909104900b6020830152600181015492820183905260020154606082015291506114999085612516565b81602001516114a891906123eb565b815182906114b790839061240b565b600f90810b90915282516000910b121590506114d257600081525b51600f0b9150610a4d9050565b5092915050565b600080839050600062093a80808360400151611502919061237e565b61150c91906123d4565b905060005b60ff8110156115bf5761152762093a8083612355565b915060008583111561153b5785925061154f565b50600082815260076020526040902054600f0b5b604084015161155e90846123a8565b846020015161156d91906123eb565b8451859061157c90839061240b565b600f0b90525085830361158f57506115bf565b80846020018181516115a191906124b3565b600f0b90525050604083018290526115b8816123bb565b9050611511565b5060008260000151600f0b12156115d557600082525b50516001600160801b03169392505050565b60408051608081018252600080825260208201819052918101829052606081019190915260408051608081018252600080825260208201819052918101829052606081019190915260035460009081906001600160a01b0388161561175b57428760200151118015611660575060008760000151600f0b135b156116a5578651611676906301e1338090612536565b600f0b6020808701919091528701516116909042906123a8565b856020015161169f91906123eb565b600f0b85525b4286602001511180156116bf575060008660000151600f0b135b156117045785516116d5906301e1338090612536565b600f0b6020808601919091528601516116ef9042906123a8565b84602001516116fe91906123eb565b600f0b84525b602080880151600090815260078252604090205490870151600f9190910b93501561175b5786602001518660200151036117405782915061175b565b602080870151600090815260079091526040902054600f0b91505b6040805160808101825260008082526020820152429181019190915243606082015281156117d0575060008181526004602090815260409182902082516080810184528154600f81810b8352600160801b909104900b9281019290925260018101549282019290925260029091015460608201525b6040810151606082015181906000428310156118235760408501516117f590426123a8565b606086015161180490436123a8565b61181690670de0b6b3a76400006123d4565b611820919061237e565b90505b600062093a80611833818761237e565b61183d91906123d4565b905060005b60ff8110156119ad5761185862093a8083612355565b915060004283111561186c57429250611880565b50600082815260076020526040902054600f0b5b61188a87846123a8565b886020015161189991906123eb565b885189906118a890839061240b565b600f0b9052506020880180518291906118c29083906124b3565b600f90810b90915289516000910b121590506118dd57600088525b60008860200151600f0b12156118f557600060208901525b604088018390529195508591670de0b6b3a764000061191487856123a8565b61191e90866123d4565b611928919061237e565b6119329086612355565b606089015261194260018a612355565b985042830361195757504360608801526119ad565b6000898152600460209081526040918290208a51918b01516001600160801b03908116600160801b0292169190911781559089015160018201556060890151600290910155506119a6816123bb565b9050611842565b5060038790556001600160a01b038e1615611a40578a602001518a602001516119d6919061240b565b866020018181516119e791906124b3565b600f0b9052508a518a516119fb919061240b565b86518790611a0a9083906124b3565b600f90810b90915260208801516000910b12159050611a2b57600060208701525b60008660000151600f0b1215611a4057600086525b6000878152600460209081526040918290208851918901516001600160801b03908116600160801b02921691909117815590870151600182015560608701516002909101556001600160a01b038e1615611c3d57428d602001511115611b005760208b0151611aaf908a6124b3565b98508c602001518c6020015103611ad25760208a0151611acf908a61240b565b98505b60208d810151600090815260079091526040902080546001600160801b0319166001600160801b038b161790555b428c602001511115611b5b578c602001518c602001511115611b5b5760208a0151611b2b908961240b565b60208d810151600090815260079091526040902080546001600160801b0319166001600160801b03831617905597505b6001600160a01b038e166000908152600660205260408120548f9190611b82906001612355565b90508060066000846001600160a01b03166001600160a01b0316815260200190815260200160002081905550428c6040018181525050438c60600181815250508b60056000846001600160a01b03166001600160a01b0316815260200190815260200160002082633b9aca008110611bfc57611bfc612392565b825160208401516001600160801b03908116600160801b02911617600391909102919091019081556040820151600182015560609091015160029091015550505b5050505050505050505050505050565b33600090815260026020908152604080832081518083019092528054600f0b825260010154918101919091529062093a80611c88818561237e565b611c9291906123d4565b905042826020015111611cd65760405162461bcd60e51b815260206004820152600c60248201526b131bd8dac8195e1c1a5c995960a21b60448201526064016105d8565b60008260000151600f0b13611d215760405162461bcd60e51b8152602060048201526011602482015270139bdd1a1a5b99c81a5cc81b1bd8dad959607a1b60448201526064016105d8565b81602001518111611d745760405162461bcd60e51b815260206004820152601f60248201527f43616e206f6e6c7920696e637265617365206c6f636b206475726174696f6e0060448201526064016105d8565b611d826301e1338042612355565b811115611da15760405162461bcd60e51b81526004016105d89061247c565b6105f633600083856003610ee2565b6001548290611dbf8682612355565b6001556040805180820190915260008082526020820152825160208085015190830152600f0b8152825187908490611df89083906124b3565b600f0b9052508515611e0c57602083018690525b6001600160a01b0388166000908152600260209081526040909120845181546001600160801b0319166001600160801b0390911617815590840151600190910155611e588882856115e7565b8615610fc5576040516340c10f1960e01b8152306004820152602481018890527f00000000000000000000000078a0a62fba6fb21a83fe8a3433d44c73a4017a6f6001600160a01b0316906340c10f1990604401600060405180830381600087803b158015611ec657600080fd5b505af1158015611eda573d6000803e3d6000fd5b505050508260200151886001600160a01b03167fbe9cf0e939c614fad640a623a53ba0a807c8cb503c4c4c8dacabe27b86ff2dd5898742604051611007939291906124e0565b6040516001600160a01b03808516602483015283166044820152606481018290526113f19085906323b872dd60e01b906084015b60408051601f198184030181529190526020810180516001600160e01b03166001600160e01b031990931692909217909152611fbb565b6040516001600160a01b0383166024820152604481018290526105f690849063a9059cbb60e01b90606401611f54565b6000612010826040518060400160405280602081526020017f5361666545524332303a206c6f772d6c6576656c2063616c6c206661696c6564815250856001600160a01b03166120909092919063ffffffff16565b905080516000148061203157508080602001905181019061203191906122d9565b6105f65760405162461bcd60e51b815260206004820152602a60248201527f5361666545524332303a204552433230206f7065726174696f6e20646964206e6044820152691bdd081cdd58d8d9595960b21b60648201526084016105d8565b6060610eda848460008585600080866001600160a01b031685876040516120b79190612574565b60006040518083038185875af1925050503d80600081146120f4576040519150601f19603f3d011682016040523d82523d6000602084013e6120f9565b606091505b509150915061210a87838387612115565b979650505050505050565b6060831561218457825160000361217d576001600160a01b0385163b61217d5760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e747261637400000060448201526064016105d8565b5081610eda565b610eda83838151156121995781518083602001fd5b8060405162461bcd60e51b81526004016105d8919061220e565b80356001600160a01b03811681146121ca57600080fd5b919050565b6000602082840312156121e157600080fd5b610cbc826121b3565b60005b838110156122055781810151838201526020016121ed565b50506000910152565b602081526000825180602084015261222d8160408501602087016121ea565b601f01601f19169190910160400192915050565b60008060006060848603121561225657600080fd5b61225f846121b3565b95602085013595506040909401359392505050565b6000806040838503121561228757600080fd5b612290836121b3565b946020939093013593505050565b6000602082840312156122b057600080fd5b5035919050565b600080604083850312156122ca57600080fd5b50508035926020909101359150565b6000602082840312156122eb57600080fd5b81518015158114610cbc57600080fd5b60208082526024908201527f43616e6e6f742061646420746f2065787069726564206c6f636b2e20576974686040820152636472617760e01b606082015260800190565b634e487b7160e01b600052601160045260246000fd5b80820180821115610a4d57610a4d61233f565b634e487b7160e01b600052601260045260246000fd5b60008261238d5761238d612368565b500490565b634e487b7160e01b600052603260045260246000fd5b81810381811115610a4d57610a4d61233f565b6000600182016123cd576123cd61233f565b5060010190565b8082028115828204841417610a4d57610a4d61233f565b600082600f0b82600f0b0280600f0b91508082146114df576114df61233f565b600f82810b9082900b0360016001607f1b0319811260016001607f1b0382131715610a4d57610a4d61233f565b60208082526024908201527f566f74696e67206c6f636b206d757374206265206174206c656173742032207760408201526365656b7360e01b606082015260800190565b6020808252601d908201527f566f74696e67206c6f636b2063616e20626520312079656172206d6178000000604082015260600190565b600f81810b9083900b0160016001607f1b03811360016001607f1b031982121715610a4d57610a4d61233f565b838152606081016004841061250557634e487b7160e01b600052602160045260246000fd5b602082019390935260400152919050565b81810360008312801583831316838312821617156114df576114df61233f565b600081600f0b83600f0b8061254d5761254d612368565b60016001607f1b031982146000198214161561256b5761256b61233f565b90059392505050565b600082516125868184602087016121ea565b919091019291505056fea264697066735822122079608050279bc2b79dc4310e2c149db653045b9a70a581263476c8293ba786e264736f6c63430008130033\n"
            + "\n";

    public static final String FUNC_MAXTIME = "MAXTIME";

    public static final String FUNC_MINTIME = "MINTIME";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_BALANCEOFAT = "balanceOfAt";

    public static final String FUNC_BALANCEOFATT = "balanceOfAtT";

    public static final String FUNC_CHECKPOINT = "checkpoint";

    public static final String FUNC_CREATE_LOCK = "create_lock";

    public static final String FUNC_CREATE_LOCK_AS_MINTER = "create_lock_as_minter";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_DEPOSIT_FOR = "deposit_for";

    public static final String FUNC_EPOCH = "epoch";

    public static final String FUNC_GET_LAST_USER_SLOPE = "get_last_user_slope";

    public static final String FUNC_INCREASE_AMOUNT = "increase_amount";

    public static final String FUNC_INCREASE_UNLOCK_TIME = "increase_unlock_time";

    public static final String FUNC_LOCKED = "locked";

    public static final String FUNC_LOCKED__END = "locked__end";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_POINT_HISTORY = "point_history";

    public static final String FUNC_SLOPE_CHANGES = "slope_changes";

    public static final String FUNC_SUPPLY = "supply";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOKEN = "token";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TOTALSUPPLYAT = "totalSupplyAt";

    public static final String FUNC_TOTALSUPPLYATT = "totalSupplyAtT";

    public static final String FUNC_USER_POINT_EPOCH = "user_point_epoch";

    public static final String FUNC_USER_POINT_HISTORY = "user_point_history";

    public static final String FUNC_USER_POINT_HISTORY__TS = "user_point_history__ts";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final Event DEPOSIT_EVENT = new Event("Deposit", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>(true) {}, new TypeReference<Uint8>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event SUPPLY_EVENT = new Event("Supply", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event WITHDRAW_EVENT = new Event("Withdraw", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected LeaveMsg(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LeaveMsg(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LeaveMsg(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LeaveMsg(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<DepositEventResponse> getDepositEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DEPOSIT_EVENT, transactionReceipt);
        ArrayList<DepositEventResponse> responses = new ArrayList<DepositEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DepositEventResponse typedResponse = new DepositEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.provider = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.locktime = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.deposit_type = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.ts = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DepositEventResponse> depositEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DepositEventResponse>() {
            @Override
            public DepositEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DEPOSIT_EVENT, log);
                DepositEventResponse typedResponse = new DepositEventResponse();
                typedResponse.log = log;
                typedResponse.provider = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.locktime = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.deposit_type = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.ts = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DepositEventResponse> depositEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DEPOSIT_EVENT));
        return depositEventFlowable(filter);
    }

    public List<SupplyEventResponse> getSupplyEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SUPPLY_EVENT, transactionReceipt);
        ArrayList<SupplyEventResponse> responses = new ArrayList<SupplyEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SupplyEventResponse typedResponse = new SupplyEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.prevSupply = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.supply = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SupplyEventResponse> supplyEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SupplyEventResponse>() {
            @Override
            public SupplyEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SUPPLY_EVENT, log);
                SupplyEventResponse typedResponse = new SupplyEventResponse();
                typedResponse.log = log;
                typedResponse.prevSupply = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.supply = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SupplyEventResponse> supplyEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SUPPLY_EVENT));
        return supplyEventFlowable(filter);
    }

    public List<WithdrawEventResponse> getWithdrawEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WITHDRAW_EVENT, transactionReceipt);
        ArrayList<WithdrawEventResponse> responses = new ArrayList<WithdrawEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WithdrawEventResponse typedResponse = new WithdrawEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.provider = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.ts = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<WithdrawEventResponse> withdrawEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, WithdrawEventResponse>() {
            @Override
            public WithdrawEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WITHDRAW_EVENT, log);
                WithdrawEventResponse typedResponse = new WithdrawEventResponse();
                typedResponse.log = log;
                typedResponse.provider = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.ts = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<WithdrawEventResponse> withdrawEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WITHDRAW_EVENT));
        return withdrawEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> MAXTIME() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAXTIME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> MINTIME() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MINTIME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String addr) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> balanceOfAt(String addr, BigInteger _block) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOFAT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr), 
                new org.web3j.abi.datatypes.generated.Uint256(_block)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> balanceOfAtT(String addr, BigInteger _t) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOFATT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr), 
                new org.web3j.abi.datatypes.generated.Uint256(_t)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> checkpoint() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CHECKPOINT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> create_lock(BigInteger _value, BigInteger _unlock_time) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CREATE_LOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value), 
                new org.web3j.abi.datatypes.generated.Uint256(_unlock_time)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> create_lock_as_minter(String _addr, BigInteger _value, BigInteger _unlock_time) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CREATE_LOCK_AS_MINTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addr), 
                new org.web3j.abi.datatypes.generated.Uint256(_value), 
                new org.web3j.abi.datatypes.generated.Uint256(_unlock_time)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> decimals() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> deposit_for(String _addr, BigInteger _value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DEPOSIT_FOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addr), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> epoch() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_EPOCH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> get_last_user_slope(String addr) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET_LAST_USER_SLOPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int128>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> increase_amount(BigInteger _value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INCREASE_AMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> increase_unlock_time(BigInteger _unlock_time) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INCREASE_UNLOCK_TIME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_unlock_time)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple2<BigInteger, BigInteger>> locked(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LOCKED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int128>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<BigInteger, BigInteger>>(function,
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> locked__end(String _addr) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LOCKED__END, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> name() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>> point_history(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_POINT_HISTORY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int128>() {}, new TypeReference<Int128>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple4<BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> slope_changes(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SLOPE_CHANGES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int128>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> supply() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> symbol() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> token() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalSupply() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> totalSupplyAt(BigInteger _block) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSUPPLYAT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_block)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> totalSupplyAtT(BigInteger t) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSUPPLYATT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(t)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> user_point_epoch(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_USER_POINT_EPOCH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>> user_point_history(String param0, BigInteger param1) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_USER_POINT_HISTORY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int128>() {}, new TypeReference<Int128>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple4<BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> user_point_history__ts(String _addr, BigInteger _idx) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_USER_POINT_HISTORY__TS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _addr), 
                new org.web3j.abi.datatypes.generated.Uint256(_idx)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static LeaveMsg load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LeaveMsg(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LeaveMsg load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LeaveMsg(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LeaveMsg load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LeaveMsg(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LeaveMsg load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LeaveMsg(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<LeaveMsg> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String token_addr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token_addr)));
        return deployRemoteCall(LeaveMsg.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<LeaveMsg> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String token_addr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token_addr)));
        return deployRemoteCall(LeaveMsg.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<LeaveMsg> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String token_addr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token_addr)));
        return deployRemoteCall(LeaveMsg.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<LeaveMsg> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String token_addr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token_addr)));
        return deployRemoteCall(LeaveMsg.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class DepositEventResponse extends BaseEventResponse {
        public String provider;

        public BigInteger locktime;

        public BigInteger value;

        public BigInteger deposit_type;

        public BigInteger ts;
    }

    public static class SupplyEventResponse extends BaseEventResponse {
        public BigInteger prevSupply;

        public BigInteger supply;
    }

    public static class WithdrawEventResponse extends BaseEventResponse {
        public String provider;

        public BigInteger value;

        public BigInteger ts;
    }
}
