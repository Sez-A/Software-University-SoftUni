import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private static Chainblock chainblock;

    @Before
    public void init() {
        chainblock = new ChainblockImpl();
    }

    @Test
    public void testAddShouldWorkProperly() {
        Transaction transaction =
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Seza", "Jim", 100);
        chainblock.add(transaction);
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testAddShouldAddOnlyUniqueIds() {
        Transaction transaction =
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Seza", "Jim", 100);
        Transaction transaction2 =
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Gosho", "Pesho", 100);

        chainblock.add(transaction);
        chainblock.add(transaction2);

        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testChangeTransactionStatusShouldWorkProperlyWhenTransactionExist() {
        Transaction transaction =
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Seza", "Jim", 100);

        chainblock.add(transaction);
        chainblock.changeTransactionStatus(1, TransactionStatus.FAILED);

        assertEquals(TransactionStatus.FAILED, transaction.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusShouldThrowException() {
        chainblock.changeTransactionStatus(1, TransactionStatus.FAILED);
    }

    @Test
    public void testRemoveTransactionByIdShouldRemoveTransactionWhenItExist() {
        Transaction transaction =
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Seza", "Jim", 100);
        chainblock.add(transaction);
        assertEquals(1, chainblock.getCount());
        chainblock.removeTransactionById(1);
        assertEquals(0, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdShouldThrowException() {
        chainblock.removeTransactionById(10);
    }

    @Test
    public void testGetByIdShouldReturnTransactionIfItExist() {
        Transaction expected =
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Seza", "Jim", 100);
        chainblock.add(expected);
        Transaction actual = chainblock.getById(1);
        assertEqualTransactions(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdShouldThrowException() {
        chainblock.getById(1);
    }

    @Test
    public void testGetByTransactionStatusShouldWorkProperly() {
        Transaction transaction =
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Seza", "Jim", 100);
        Transaction transaction2 =
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Gosho", "Pesho", 200);
        Transaction transaction3 =
                new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Jim", "Seza", 300);
        Transaction transaction4 =
                new TransactionImpl(4, TransactionStatus.UNAUTHORIZED, "Asen", "Ivan", 400);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);
        chainblock.add(transaction4);
        List<Transaction> expected = List.of(transaction3, transaction2, transaction);

        List<Transaction> actual
                = (List<Transaction>) chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(expected.size(), actual.size());
        assertEqualTransactionLists(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusShouldThrowException() {
        Transaction transaction =
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Seza", "Jim", 100);
        Transaction transaction2 =
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Gosho", "Pesho", 200);
        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.getByTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatusShouldWorkProperly() {
        Transaction transaction =
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Seza", "Jim", 100);
        Transaction transaction2 =
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Seza", "Pesho", 200);
        Transaction transaction3 =
                new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Jim", "Ivan", 300);
        Transaction transaction4 =
                new TransactionImpl(4, TransactionStatus.UNAUTHORIZED, "Asen", "Ivan", 400);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);
        chainblock.add(transaction4);

        List<String> expected = List.of(transaction3.getFrom(), transaction2.getFrom(), transaction.getFrom());
        List<String> actual = (List<String>) chainblock
                .getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusShouldThrowException() {
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusShouldWorkProperly() {
        Transaction transaction =
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Seza", "Jim", 100);
        Transaction transaction2 =
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Gosho", "Jim", 200);
        Transaction transaction3 =
                new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Jim", "Ivan", 300);
        Transaction transaction4 =
                new TransactionImpl(4, TransactionStatus.UNAUTHORIZED, "Asen", "Ivan", 400);
        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);
        chainblock.add(transaction4);
        List<String> expected = List.of(transaction3.getTo(), transaction2.getTo(), transaction.getTo());
        List<String> actual = (List<String>) chainblock
                .getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusShouldThrowException() {
        Transaction transaction =
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Seza", "Jim", 100);
        chainblock.add(transaction);
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenByIdShouldWorkProperlyWithDiffTransactionAmounts() {
        List<Transaction> transactions = makeThreeTransactions();
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));
        chainblock.add(transactions.get(2));

        List<Transaction> expected = List.of(transactions.get(2), transactions.get(1), transactions.get(0));
        List<Transaction> actual = (List<Transaction>) chainblock.getAllOrderedByAmountDescendingThenById();
        assertEquals(expected.size(), actual.size());
        assertEqualTransactionLists(expected, actual);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenByIdShouldWorkProperlyWithSameTransactionAmounts() {
        List<Transaction> transactions = makeThreeTransactions();
        transactions.get(0).setAmount(100);
        chainblock.add(transactions.get(0));
        transactions.get(1).setAmount(100);
        chainblock.add(transactions.get(1));
        chainblock.add(transactions.get(2));

        List<Transaction> expected = List.of(transactions.get(2), transactions.get(0), transactions.get(1));
        List<Transaction> actual = (List<Transaction>) chainblock.getAllOrderedByAmountDescendingThenById();
        assertEquals(expected.size(), actual.size());
        assertEqualTransactionLists(expected, actual);
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingShouldWorkWhenSenderExist() {
        List<Transaction> transactions = makeThreeTransactions();
        transactions.get(1).setFrom("Seza");
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));
        chainblock.add(transactions.get(2));

        List<Transaction> expected = List.of(transactions.get(1), transactions.get(0));
        List<Transaction> actual = (List<Transaction>) chainblock.getBySenderOrderedByAmountDescending("Seza");
        assertEqualTransactionLists(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingShouldThrowException() {
        chainblock.getBySenderOrderedByAmountDescending("Nobody");
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenByIdShouldReturnListOrderedByAmount() {
        List<Transaction> transactions = makeThreeTransactions();
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));
        chainblock.add(transactions.get(2));

        List<Transaction> expected = List.of(transactions.get(1), transactions.get(0));
        List<Transaction> actual = (List<Transaction>) chainblock.getByReceiverOrderedByAmountThenById("Jim");

        assertEqualTransactionLists(expected, actual);
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenByIdShouldReturnListOrderedByIds() {
        List<Transaction> transactions = makeThreeTransactions();
        transactions.get(1).setAmount(100);

        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));
        chainblock.add(transactions.get(2));

        List<Transaction> expected = List.of(transactions.get(0), transactions.get(1));
        List<Transaction> actual = (List<Transaction>) chainblock.getByReceiverOrderedByAmountThenById("Jim");

        assertEqualTransactionLists(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenByIdShouldThrowException() {
        chainblock.getByReceiverOrderedByAmountThenById("Not exist");
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyList() {
        List<Transaction> actual = (List<Transaction>) chainblock
                .getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 100);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldWork() {
        List<Transaction> transactions = makeThreeTransactions();
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));
        chainblock.add(transactions.get(2));
        List<Transaction> expected = List.of(transactions.get(1), transactions.get(0));
        List<Transaction> actual = (List<Transaction>) chainblock
                .getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 200);
        assertEqualTransactionLists(expected, actual);
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescendingShouldWorkProperly() {
        List<Transaction> transactions = makeThreeTransactions();
        transactions.get(2).setFrom("Gosho");
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));
        chainblock.add(transactions.get(2));
        List<Transaction> expected = List.of(transactions.get(2), transactions.get(1));

        List<Transaction> actual = (List<Transaction>) chainblock.
                getBySenderAndMinimumAmountDescending("Gosho", 199);
        assertEqualTransactionLists(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingShouldThrowException() {
        chainblock.getBySenderAndMinimumAmountDescending("Petko", 5000);
    }

    @Test
    public void testGetByReceiverAndAmountRangeShouldReturnListOrderedByAmount() {
        List<Transaction> transactions = makeThreeTransactions();
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));
        chainblock.add(transactions.get(2));

        List<Transaction> expected = List.of(transactions.get(1), transactions.get(0));
        List<Transaction> actual = (List<Transaction>) chainblock
                .getByReceiverAndAmountRange("Jim", 100, 201);

        assertEqualTransactionLists(expected, actual);
    }

    @Test
    public void testGetByReceiverAndAmountRangeShouldReturnListOrderedById() {
        List<Transaction> transactions = makeThreeTransactions();
        transactions.get(1).setAmount(100);

        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));
        chainblock.add(transactions.get(2));

        List<Transaction> expected = List.of(transactions.get(0), transactions.get(1));
        List<Transaction> actual = (List<Transaction>) chainblock
                .getByReceiverAndAmountRange("Jim", 100, 201);

        assertEqualTransactionLists(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeShouldThrowException() {
        chainblock.getByReceiverAndAmountRange("Alex", 1000, 2010);
    }

    @Test
    public void testGetAllInAmountRangeShouldReturnEmptyList() {
        List<Transaction> actual = (List<Transaction>) chainblock.getAllInAmountRange(1000, 10000);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testGetAllInAmountRangeShouldWorkProperly() {
        List<Transaction> transactions = makeThreeTransactions();
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));
        chainblock.add(transactions.get(2));

        List<Transaction> expected = List.of(transactions.get(0), transactions.get(1));
        List<Transaction> actual = (List<Transaction>) chainblock.getAllInAmountRange(100, 200);
        assertEqualTransactionLists(expected, actual);
    }


    private List<Transaction> makeThreeTransactions() {
        Transaction transaction =
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Seza", "Jim", 100);
        Transaction transaction2 =
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Gosho", "Jim", 200);
        Transaction transaction3 =
                new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Jim", "Ivan", 300);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        transactions.add(transaction2);
        transactions.add(transaction3);
        return transactions;
    }

    private void assertEqualTransactionLists(List<Transaction> expected, List<Transaction> actual) {
        for (int i = 0; i < expected.size(); i++) {
            assertEqualTransactions(expected.get(i), actual.get(i));
        }
    }


    private void assertEqualTransactions(Transaction first, Transaction second) {
        assertEquals(first.getId(), second.getId());
        assertEquals(first.getStatus(), second.getStatus());
        assertEquals(first.getAmount(), second.getAmount(), 0);
        assertEquals(first.getFrom(), second.getFrom());
        assertEquals(first.getTo(), second.getTo());
    }
}